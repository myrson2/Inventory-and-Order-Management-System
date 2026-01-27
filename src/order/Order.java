package order;

import java.util.ArrayList;

import user.Customer;
import product.Product;

public class Order {
    public ArrayList<OrderItem> items = new ArrayList<>();
    private String orderId;
    private Customer customer;
    private double totalAmount;
    private OrderStatus orderStatus;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
        this.orderStatus = OrderStatus.PENDING;  // Start as PENDING
    }

    public void addItem(Product product, int quantity){
        OrderItem orderItem = new OrderItem(product, quantity);
        items.add(orderItem);
    }

    public double calculateTotal(){
        totalAmount = 0;
        for (OrderItem orderItem : items) {
            totalAmount += orderItem.getSubTotal();
        }

        return totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }
 
    public String getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return calculateTotal();
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }
}
