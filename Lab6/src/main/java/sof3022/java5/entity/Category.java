package sof3022.java5.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "categories")

public class Category {
    @Id
    @Column(name = "id", length = 4)
    String id;

    @Column(name = "name", length = 50)
    String name;

    @OneToMany(mappedBy = "category")
    List<Product> products;

}
