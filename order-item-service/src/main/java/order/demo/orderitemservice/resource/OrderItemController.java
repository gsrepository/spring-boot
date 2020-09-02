package order.demo.orderitemservice.resource;

import order.demo.orderitemservice.entity.OrderItem;
import order.demo.orderitemservice.entity.OrderItemData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    @RequestMapping("/test")
    public String getSomeProduct(){
        return "Hi this is test product";
    }

    @RequestMapping("/all")
    public List<OrderItem> getAllItems(){
        List<OrderItem> items = orderItemService.getAllItems();
        return items;
    }

    @RequestMapping("/{id}")// maps the request URL in DELETE method to add the OrderItem
    public Optional<OrderItem> getItem(@PathVariable("id") String id) {
        return orderItemService.getItemById(id);
    }

    @PostMapping("/add")// maps the request URL in POST method to add the OrderItem
    public OrderItem adItem(@RequestBody OrderItem orderItem) {
        orderItemService.addItem(orderItem);
        return orderItem;
    }

    @DeleteMapping("/{id}")// maps the request URL in DELETE method to add the OrderItem
    public void deleteItem(@PathVariable("id") String id) {
        orderItemService.deleteItemById(id);
    }

    @PutMapping(path="/item", consumes= {"application/json"})// takes the entity as json using PUT method and updates the record
    public OrderItem updateItem(@RequestBody OrderItem orderItem) {
        orderItemService.updateItem(orderItem);
        return orderItem;

    }

    @RequestMapping("/ordebyid/{orderid}")
    public OrderItemData getItemsByOrderId(@PathVariable("orderid") String orderid){
        OrderItemData orderItemData = orderItemService.getItemsByOrderId(orderid);
        return orderItemData;
    }



}
