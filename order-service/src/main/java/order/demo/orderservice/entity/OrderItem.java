package order.demo.orderservice.entity;

import javax.persistence.*;

@Entity
@Table(name="ORDER_ITEMS")
public class OrderItem {

    @Id
    private String id;
    private String productCode;
    private String productName;
    private int quantity;
    private String orderId;
    @ManyToOne
    //@JoinColumn(name="order_id")
    private Order order;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}