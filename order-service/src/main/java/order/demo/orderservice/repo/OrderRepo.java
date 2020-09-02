package order.demo.orderservice.repo;

import order.demo.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,String> {

    Order findByOrderId(String orderId);
}
