package order.demo.orderitemservice.repo;

import order.demo.orderitemservice.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemRepo extends JpaRepository<OrderItem,String> {

    @Query("Select item from OrderItem item where item.orderId=:orderId")
    public List<OrderItem> getItemsByOrderId(@Param("orderId") String orderId);


}
