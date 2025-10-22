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
@Builder

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "username", length = 50)
    String username;

    @Column(name = "password", length = 50)
    String password;

    @Column(name = "fullname", length = 50)
    String fullname;

    @Column(name = "Email")
    String email;

    @Column(name = "photo")
    String photo;

    @Column(name = "activated")
    Boolean activated;

    @Column(name = "admin")
    Boolean admin;

    @OneToMany(mappedBy = "account")
    List<Order> orders;

}
