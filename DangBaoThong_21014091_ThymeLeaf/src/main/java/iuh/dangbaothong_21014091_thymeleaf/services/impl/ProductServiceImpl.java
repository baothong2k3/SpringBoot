/*
 * @ (#) ProductServiceImpl.java    1.0    23/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package iuh.dangbaothong_21014091_thymeleaf.services.impl;/*
 * @description:
 * @author: Bao Thong
 * @date: 23/11/2024
 * @version: 1.0
 */

import iuh.dangbaothong_21014091_thymeleaf.entities.Product;
import iuh.dangbaothong_21014091_thymeleaf.repositories.ProductRepository;
import iuh.dangbaothong_21014091_thymeleaf.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findProductByCategory(Integer categoryId, Pageable pageable) {
        return productRepository.findProductByCatergory_Id(categoryId, pageable);
    }

    @Override
    public Page<Product> findAllProducts(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return productRepository.findAll(pageable);
    }


    @Transactional
    /*
    Đảm bảo rằng thao tác save trên productRepository được thực thi.
    Nếu thao tác lưu thất bại sẽ được rollback, ngăn chặn các cập nhật không hoàn chỉnh đối với cơ sở dữ liệu.
     */
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Product updateProduct(int id, Product product) {
        Product existingProduct = productRepository.findById(id);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setCode(product.getCode());
            existingProduct.setRegisterDate(product.getRegisterDate());
            existingProduct.setPrice(product.getPrice());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Page<Product> searchProduct(String keyword, Pageable pageable) {
        return productRepository.search(keyword, pageable);
    }


    @Override
    public Product findProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean existsById(int id) {
        return productRepository.existsById(id);
    }
}
