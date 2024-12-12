package in.dchandwani.ecommerce.order.repository;

import in.dchandwani.ecommerce.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  OrderRepository extends JpaRepository<Order, Integer> {
}
