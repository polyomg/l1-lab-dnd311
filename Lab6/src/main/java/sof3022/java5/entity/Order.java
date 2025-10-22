package sof3022.java5.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "username")
    Account account;

    @Column(name = "created_date")
    LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "address", length = 100)
    String address;

    @OneToMany(mappedBy = "order")
    List<OrderDetail> orderDetails;

}
