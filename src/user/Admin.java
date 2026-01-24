package user;

import java.util.ArrayList;

import inventory.Inventory;
import product.NonPerishableProduct;
import product.Product;

public class Admin extends User{
    Inventory inventory = null;

    public Admin(String id, String name, String email){
        super(id, name, email);
    }

    @Override
    public void performRoleAction() {
        System.out.println("Admin is managing products and inventory.");
    }

    public void addProduct(Product product){
        inventory.addProduct(product);
        System.out.println();
    }

     public void updateStocks(String productId, int amount){
        inventory.updateStocks(productId, amount);
        System.out.println();
        }

    public void getProductById(String productId){
        
    }

    // public void viewProducts()
    // {
    //     for (Product product : listOfProducts) {
    //         product.getProductDetails();
    //     }
    // }

   
}
