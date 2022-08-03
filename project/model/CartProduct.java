package project.model;

public class CartProduct {
    private int id;
    private static int counter=1;
    private Product product;
    private int quantity;

    public int getId(){
        return id;
    }
    public Product getProduct(){
        return product;
    }
    public int getQuantity(){
        return quantity;
    }

    public CartProduct(Product product, int quantity){
        id = counter;
        counter++;

        this.product = product;
        this.quantity = quantity;
    }

    public double Price(){
        return product.getPrice()*quantity;
    }
}
