package order.demo.orderitemservice.resource;

import order.demo.orderitemservice.entity.OrderItem;
import order.demo.orderitemservice.entity.OrderItemData;
import order.demo.orderitemservice.repo.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepo orderItemRepo;

    public List<OrderItem> getAllItems() {
        List<OrderItem> items = orderItemRepo.findAll();
        return items;
    }

    public Optional<OrderItem> getItemById(String id) {
        Optional<OrderItem> item = orderItemRepo.findById(id);
        return item;
    }

    public void deleteItemById(String id){
        OrderItem item = orderItemRepo.getOne(id);
        orderItemRepo.delete(item);

    }

    public void addItem(OrderItem orderItem){

        orderItemRepo.save(orderItem);
    }

    public void updateItem(OrderItem orderItem){

        orderItemRepo.save(orderItem);
    }

    public OrderItemData getItemsByOrderId(String orderId){
        OrderItemData orderItemData = new OrderItemData();
        List<OrderItem> orderItems = this.orderItemRepo.getItemsByOrderId(orderId);
        orderItemData.setOrderItems(orderItems);
        System.out.println("Order Items for the order : "+orderItemData.getOrderItems());
        return orderItemData;
    }

//    public List<OrderItem> getItemsByOrderId(String orderId){
//        return this.orderItemRepo.getItemsByOrderId(orderId);
//    }

}
