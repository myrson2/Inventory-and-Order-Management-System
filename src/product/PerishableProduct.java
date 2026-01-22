package product;

import java.time.LocalDate;

public class PerishableProduct extends Product{
    private LocalDate expirationDate;

    public PerishableProduct(String name, double price, int quantity, LocalDate expirationDate){
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    @Override
    public void getProductDetails() {
        System.out.println("====== Perishable Products =====");
        super.getProductDetails();
        System.out.println("Expiration: " + expirationDate);
    }
}
