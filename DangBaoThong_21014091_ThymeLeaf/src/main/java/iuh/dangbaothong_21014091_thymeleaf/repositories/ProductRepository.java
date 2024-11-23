package iuh.dangbaothong_21014091_thymeleaf.repositories;

import iuh.dangbaothong_21014091_thymeleaf.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT p FROM Product p WHERE CAST(p.id AS string) LIKE %:keyword%"
            + " OR p.name LIKE %:keyword%"
            + " OR p.code LIKE %:keyword%"
            + " OR CAST(p.registerDate AS string) LIKE %:keyword%"
            + " OR CAST(p.price AS string) LIKE %:keyword%")
    public List<Product> search(@Param("keyword") String keyword);

    public Product findById(int id);

    public Page<Product> findProductByCatergory_Id(int categoryId, Pageable pageable);

    public boolean existsById(int id);
}
