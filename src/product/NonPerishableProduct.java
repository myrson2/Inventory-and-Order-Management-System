package product;

public class NonPerishableProduct extends Product{
    private int warrantyMonths;

    public NonPerishableProduct(String name, double price, int quantity, int warrantyMonths){
        super(name, price, quantity);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void getProductDetails() {
        System.out.println("====== Non-Perishable Products =====");
        super.getProductDetails();
        System.out.println("Warranty: " + warrantyMonths + " months");
    }
}
