package project.model;

import java.util.Date;

public class OrderInfo {
    private int id;
    private static int counter = 1;
    private Cart cart;
    private DeliveryMethod deliveryMethod;
    private Date deliveryDate;
    private OrderStatus status;

    public int getId(){
        return id;
    }
    public Cart getCart(){
        return cart;
    }
    public OrderStatus getStatus(){
        return status;
    }
    public void setStatus(OrderStatus status){
        this.status = status;
    }
    public OrderInfo(Cart cart, DeliveryMethod deliveryMethod, Date deliveryDate){
        id = counter;
        counter++;

        this.cart = cart;
        this.deliveryMethod = deliveryMethod;
        this.deliveryDate = deliveryDate;
        status = OrderStatus.Ordered;
    }

    public double TotalPrice(){
        if(deliveryMethod == DeliveryMethod.InStorePickUp){
            return cart.TotalPrice();
        }
        else if(deliveryMethod == DeliveryMethod.MailByChargingFee){
            return cart.TotalPrice()+3;
        }
        return 0;
    }

    @Override
    public String toString(){
        return "Delivery Method: "+deliveryMethod.toString()+"\n Delivery date: "+deliveryDate+"\n Status: "+status.toString();
    }
}
