package order;

import product.Product;

public class OrderItem {
    private Product product;
    private int quantity;
    private double subTotal;

    OrderItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
        this.subTotal = calculateSubTotal();
    }

    public double calculateSubTotal(){
        return quantity * product.getPrice();
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void getItemDetails() {
    // Use %f instead of %lf and add \n at the end
    System.out.printf("Item: %s || Quantity: %d || Subtotal: %.2f\n", 
                      product.getName(), quantity, subTotal);
}
}
