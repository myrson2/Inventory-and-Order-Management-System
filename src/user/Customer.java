package user;

import inventory.Inventory;
import order.Order;
import order.OrderItem;

public class Customer extends User{
     private Inventory inventory;

     public Customer(String id, String name, String email, Inventory inventory){
        super(id, name, email);
        this.inventory = inventory;
    }

    @Override
    public void performRoleAction() {
        System.out.println("Customer is browsing products and placing orders.");
    }

    public void getAllProducts(){
        inventory.getAllProducts();
    }

    public void placeOrder(Order order){

    }
    
    public void viewOrderDetails(Order order){
        System.out.println("===== Your Orders =====");
        System.out.printf("Order ID: %s || Customer: %s\n", order.getOrderId(), order.getCustomer().getName());
        System.out.println();

        for (OrderItem items : order.getItems()) {
            items.getItemDetails();
        }

        System.out.println();

        System.out.println("Total Amount: " + order.getTotalAmount() + " || Order Status: " + order.getOrderStatus());
    }
}
