package product;
import java.util.Random;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity){
        this.id = productIdGenerator(new Random());
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String id, String name, double price, int quantity){
        
        if(id == null || id.isEmpty()){
            this.id = productIdGenerator(new Random()); // generate new ID if none provided
        } else {
            this.id = id; // use the provided ID
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public void increaseStock(int amount){
        if (amount > 0) {
            quantity += amount;
            System.out.println("Stock increased by " + amount + ". New quantity: " + quantity);
        } else {
            System.out.println("Invalid amount: must be positive.");
        }
    }

    static String productIdGenerator(Random random){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 5;
        
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    public void getProductDetails(){
        System.out.println("Product Name: " + name);
        System.out.println("Product Id: " + id);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    };

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
