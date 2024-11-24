package iuh.dangbaothong_21014091_thymeleaf.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    @Size(max = 20, message = "Name must be at most 20 characters")
    private String name;

    @Column(name = "Code")
    @Pattern(regexp = "Pro\\d{3}-(0[1-9]|1[0-2])", message = "Code must follow the pattern ProXXX-MM")
    private String code;

    @Column(name = "Description")
    @NotBlank(message = "Description cannot be empty")
    private String description;

    @Column(name = "REGISTER_DATE", columnDefinition = "date")
    @Past(message = "Register date must be in the past")
    private LocalDate registerDate;

    @Column(name = "PRICE")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cart_ID", nullable = false)
    private Catergory catergory;

    public Product() {
    }

    public Product(String name, String code, String description, LocalDate registerDate, Double price, Catergory catergory) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.registerDate = registerDate;
        this.price = price;
        this.catergory = catergory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Catergory getCatergory() {
        return catergory;
    }

    public void setCatergory(Catergory catergory) {
        this.catergory = catergory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", registerDate=" + registerDate +
                ", price=" + price +
                ", catergory=" + catergory +
                '}';
    }
}
