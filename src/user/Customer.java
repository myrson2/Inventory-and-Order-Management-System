package user;

import inventory.Inventory;

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
    
}
