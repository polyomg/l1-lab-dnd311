package sof3022.java5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sof3022.java5.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
