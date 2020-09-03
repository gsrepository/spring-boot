package order.demo.orderitemservice.entity;

import java.util.Arrays;
import java.util.List;

public class OrderItemData {

    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        if(orderItems == null){
            orderItems = Arrays.asList();
        }
        this.orderItems = orderItems;
    }
}
