package user;

import java.util.ArrayList;

import product.NonPerishableProduct;
import product.Product;

public class Admin extends User{
    ArrayList<Product> listOfProducts = new ArrayList<>();

    public Admin(String id, String name, String email){
        super(id, name, email);
    }

    @Override
    public void performRoleAction() {
        System.out.println("Admin is managing products and inventory.");
    }

    public void addProduct(Product product){
        if(product == null){
            System.out.println("Add Some details first.");
            return; // Prevent adding null products
        }
        listOfProducts.add(product);

        System.out.println("Successfully Added.");
    }

    public void viewProducts()
    {
        for (Product product : listOfProducts) {
            product.getProductDetails();
        }
    }
}
