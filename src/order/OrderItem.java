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

    public void getItemDetails(){
        System.out.printf("Item: %s || Quantity: %d || Subtotal: %lf", product.getName(), quantity, subTotal);
    }
}
