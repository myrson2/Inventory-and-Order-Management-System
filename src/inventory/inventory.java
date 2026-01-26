package inventory;

import java.util.ArrayList;
import product.Product;

public class Inventory {
    ArrayList<Product> products = new ArrayList<>();

    public boolean addProduct(Product product){ // make this function in boolean
        products.add(product);

        if(products == null){
            return false;
        }

        return true;
    }

    public boolean updateStocks(String productId, int amount){
        if(products.isEmpty()){
            System.out.println("Add Products first");
            return false;
        }

        int flag = 0;
        for (Product product : products) {
            if(productId.equalsIgnoreCase(product.getId())){
                product.increaseStock(amount);
                flag = 1;
                break;
            }
        }

        if(flag == 0) {
            return false;
        } 

        return true;
    }

    public String getProductById(String productId){
        int flag = 0;
        String returnProductId = "";
        
        for (Product product : products) {
            if(productId.equalsIgnoreCase(product.getId())){
                returnProductId = product.getId();
                flag = 1;
                break;
            }
        }

        if(flag == 1) {
            System.out.println("Item is found.");
        } else {
            System.out.println("Not Found.");
        }

        return returnProductId;
    }

    public void getAllProducts(){
        for (Product product : products) {
            product.getProductDetails();
        }
    }

    public boolean removeProduct(String productId) {
    String targetId = getProductById(productId);
    
    return products.removeIf(product -> 
        product.getId().equalsIgnoreCase(targetId)
    );
}

}
