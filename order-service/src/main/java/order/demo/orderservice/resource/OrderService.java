package order.demo.orderservice.resource;

import order.demo.orderservice.entity.Order;
import order.demo.orderservice.entity.OrderItem;
import order.demo.orderservice.entity.OrderItemData;
import order.demo.orderservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    private RestTemplate restTemplate;

    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    public OrderItemData getOrderItem(String orderId){
        OrderItemData orderItemData = restTemplate.getForObject("http://localhost:8086/items/ordebyid/"+orderId,OrderItemData.class);
        return orderItemData;
    }

    public Order getOrderByOrderId(String orderId){

        Order item = orderRepo.findByOrderId(orderId);

        OrderItemData orderItemData = restTemplate.getForObject("http://localhost:8086/items/ordebyid/"+orderId,OrderItemData.class);

        item.setOrderItems(orderItemData.getOrderItems());
        return item;
    }

}
