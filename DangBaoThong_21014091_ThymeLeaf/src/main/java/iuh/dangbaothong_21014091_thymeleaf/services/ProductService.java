package iuh.dangbaothong_21014091_thymeleaf.services;

import iuh.dangbaothong_21014091_thymeleaf.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> findAllProducts(Pageable pageable);

    public Page<Product> findAllProducts(int pageNo, int pageSize, String sortBy, String sortDirection);

    public Product saveProduct(Product product);

    public Product updateProduct(int id, Product product);

    public boolean delete(int id);

    public List<Product> searchProduct(String keyword);

    Page<Product> findProductByCategory(Integer categoryId, Pageable pageable);

    public Product findProductById(int id);

    public boolean existsById(int id);

}
