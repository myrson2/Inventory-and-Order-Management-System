package user;

import inventory.Inventory;
import product.Product;

public class Admin extends User{
    Inventory inventory = new Inventory();

    public Admin(String id, String name, String email){
        super(id, name, email);
    }

    @Override
    public void performRoleAction() {
        System.out.println("Admin is managing products and inventory.");
    }

    public void addProduct(Product product){
        if(inventory.addProduct(product)){
            System.out.println("Successfully Added!");
        } else {
            System.out.println("Add Products");
        }
        System.out.println();
    }

     public void updateStocks(String productId, int amount){
        if(inventory.updateStocks(productId, amount)){
            System.out.println("Updated Successfully!");
        } else {
            System.out.println("Not found");
        }

        System.out.println();
        }
        
    public void getAllProducts(){
        inventory.getAllProducts();
        System.out.println();
    }

   public void removeProduct(String productId){
    boolean isRemove = inventory.removeProduct(productId);
        if(isRemove) {
            System.out.println("Remove Successfully");
        } else {
            System.out.println("Not found");
        }
   }

}
