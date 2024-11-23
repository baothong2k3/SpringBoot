package iuh.dangbaothong_21014091_thymeleaf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CATERGORY")
public class Catergory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cart_ID")
    private int id;

    @Column(name = "Name")
    private String name;

    public Catergory() {
    }

    public Catergory(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Catergory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
