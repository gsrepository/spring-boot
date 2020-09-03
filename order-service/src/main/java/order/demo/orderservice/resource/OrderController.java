package order.demo.orderservice.resource;

import order.demo.orderservice.entity.Order;
import order.demo.orderservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderitems")
public class OrderController {

    @Autowired
    OrderService orderService;



    @RequestMapping("/all")
    public List<Order> getOrders(){
        return orderService.getAllOrders();
    }

    @RequestMapping("orderid/{id}")
    public Order getOrders(@PathVariable("id") String orderId){
        return orderService.getOrderByOrderId(orderId);
    }

}
