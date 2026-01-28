package user;

import inventory.Inventory;
import order.Order;
import order.OrderItem;

public class Customer extends User{
     private Inventory inventory;
     private Order currentOrder;

     public Customer(String id, String name, String email, Inventory inventory){
        super(id, name, email);
        this.inventory = inventory;
    }

    public void setCurrentOrder(Order order) {
        this.currentOrder = order;
    }

    @Override
    public void performRoleAction() {
        System.out.println("Customer is browsing products and placing orders.");
    }

    public void getAllProducts(){
        inventory.getAllProducts();
    }

    public void placeOrder(Order order){
            // Check if the order has items before processing
            if (order.getItems().isEmpty()) {
                System.out.println("Error: Cannot place an empty order.");
                return;
            }

            // You can add logic here to finalize the order status if needed
            // For example, logic to transition from PENDING to PAID could go here.

            System.out.println("---------------------------");
            System.out.println("Order successfully placed!");
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Total Amount: " + order.getTotalAmount());
            System.out.println("---------------------------");
        }
    
    public void viewOrderDetails(){
       if (currentOrder == null) {
            System.out.println("No active order found.");
            return;
        }

        System.out.println("===== Your Orders =====");
        // Using getName() from the parent User class
        System.out.printf("Order ID: %s || Customer: %s\n", 
            currentOrder.getOrderId(), this.getName()); 
        System.out.println();

        for (OrderItem item : currentOrder.getItems()) {
            item.getItemDetails();
        }

        System.out.println();
        System.out.println("Total Amount: " + currentOrder.getTotalAmount() + 
                           " || Order Status: " + currentOrder.getOrderStatus());
    }
}
