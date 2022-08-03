package project.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int id;
    private static int count = 1;
    private List<CartProduct> cartProducts;

    public List<CartProduct> getCartProducts(){
        return cartProducts;
    }

    public Cart(){
        id = count;
        count++;

        cartProducts = new ArrayList<>();
    }

    public double TotalPrice(){
        double totalPrice = 0;
        for(CartProduct cp: cartProducts){
            totalPrice+=cp.Price();
        }
        return totalPrice;
    }
}
