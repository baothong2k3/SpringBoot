package iuh.dangbaothong_21014091_thymeleaf.controllers;

import iuh.dangbaothong_21014091_thymeleaf.entities.Catergory;
import iuh.dangbaothong_21014091_thymeleaf.entities.Product;
import iuh.dangbaothong_21014091_thymeleaf.services.CatergoryService;
import iuh.dangbaothong_21014091_thymeleaf.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CatergoryService catergoryService;

    @GetMapping("/products")
    public String listProductsByCategory(Model model, @RequestParam(required = false) Integer categoryId, @RequestParam(defaultValue = "0") int page) {
        List<Catergory> categories = catergoryService.findAllCatergories();
        model.addAttribute("categories", categories);

        Pageable pageable = PageRequest.of(page, 10);
        Page<Product> productPage;
        if (categoryId != null) {
            productPage = productService.findProductByCategory(categoryId, pageable);
        } else {
            productPage = productService.findAllProducts(pageable);
        }
        model.addAttribute("productPage", productPage);
        model.addAttribute("currentPage", page);
        return "product_list";
    }

    @GetMapping("/products/view/{id}")
    public String viewProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "view_product";
    }

    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable("id") int id, Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "edit_product";
    }

    @PostMapping("/products/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Product product) {
        productService.updateProduct(id, product);
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/products";
    }

    @GetMapping("/addProduct")
    public String showAddProductForm(Model model) {
        List<Catergory> categories = catergoryService.findAllCatergories();
        for (Catergory catergory : categories) {
            System.out.println(catergory.getName());
        }
        model.addAttribute("product", new Product());
        model.addAttribute("catergories", categories);
        return "add_product";
    }

    @GetMapping("/addCategory")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("catergory", new Catergory());
        return "add_category";
    }

    @Transactional
    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute Product product, BindingResult result, Model model,
                             @RequestParam("catergoryId") Integer catergoryId) {
        List<Catergory> categories = catergoryService.findAllCatergories();
        Catergory catergory = catergoryService.findCatergoryById(catergoryId);
        product.setCatergory(catergory);
        System.out.println(product.toString());
        if (result.hasErrors()) {
            model.addAttribute("catergories", categories);
            return "add_product";
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @PostMapping("/categories/add")
    public String addCategory(@ModelAttribute Catergory catergory, BindingResult result) {
        if (result.hasErrors()) {
            return "add_category";
        }
        catergoryService.saveCatergory(catergory);
        return "redirect:/products";
    }
}