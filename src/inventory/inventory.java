package inventory;

import java.util.ArrayList;
import product.Product;

public class Inventory {
    ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product){ // make this function in boolean
        products.add(product);
    }

    public void updateStocks(String productId, int amount){
        int flag = 0;
        for (Product product : products) {
            if(productId.equalsIgnoreCase(product.getId())){
                product.increaseStock(amount);
                flag = 1;
                break;
            }
        }

        if(flag == 1) {
            System.out.println("Item is Updated.");
        } else {
            System.out.println("Not Found.");
        }
    }

    public String getProductById(String productId){
        int flag = 0;
        String returnProduct = "";
        
        for (Product product : products) {
            if(productId.equalsIgnoreCase(product.getId())){
                returnProduct = product.getName();
                flag = 1;
                break;
            }
        }

        if(flag == 1) {
            System.out.println("Item is Updated.");
        } else {
            System.out.println("Not Found.");
        }

        return returnProduct;
    }
}
