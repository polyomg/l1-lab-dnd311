package sof3022.java5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sof3022.java5.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
