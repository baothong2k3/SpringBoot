package iuh.dangbaothong_21014091_thymeleaf.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Code")
    private String code;
    @Column(name = "Description")
    private String description;
    @Column(name = "REGISTER_DATE")
    private LocalDateTime registerDate;
    @Column(name = "PRICE")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cart_ID", nullable = false)
    private Catergory catergory;

    public Product() {
    }

    public Product(String name, String code, String description, LocalDateTime registerDate, Double price, Catergory catergory) {
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

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
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
