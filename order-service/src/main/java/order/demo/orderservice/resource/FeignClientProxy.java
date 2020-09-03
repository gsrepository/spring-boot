package order.demo.orderservice.resource;


import feign.Headers;
import order.demo.orderservice.entity.Order;
import order.demo.orderservice.entity.OrderItem;
import order.demo.orderservice.entity.OrderItemData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Headers("Content-Type: application/json")
@FeignClient(name="order-item-service", url= "http://localhost:8086", fallback = OrderItemServiceFallback.class)
public interface FeignClientProxy {

    @RequestMapping("items/ordebyid/{orderid}")
    public OrderItemData getItemsByOrderId(@PathVariable(value="orderid") String orderid);

//    @Component
//    class OrderItemServiceFallback implements FeignClientProxy{
//
//        @Override
//        public OrderItemData getItemsByOrderId(String orderid) {
//            System.out.println("FALL BACK on Exception in service");
//            OrderItemData item = new OrderItemData();
//            item.setOrderItems(Arrays.asList());
//            return item;
//        }
//    }



//    @RequestMapping("/all")
//    public List<OrderItem> getAllItems();
//    @RequestMapping("/{id}")// maps the request URL in DELETE method to add the OrderItem
//    public Optional<OrderItem> getItem(@PathVariable("id") String id);
//
//    @PostMapping("/add")// maps the request URL in POST method to add the OrderItem
//    public OrderItem adItem(@RequestBody OrderItem orderItem);
//
//    @DeleteMapping("/{id}")// maps the request URL in DELETE method to add the OrderItem
//    public void deleteItem(@PathVariable("id") String id);
//
//    @PutMapping(path="/item", consumes= {"application/json"})// takes the entity as json using PUT method and updates the record
//    public OrderItem updateItem(@RequestBody OrderItem orderItem);
}
