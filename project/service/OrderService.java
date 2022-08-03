package project.service;

import project.Database;
import project.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService {
    private final Database db;
    public OrderService(){
        db = new Database();
    }

    //SELECT ITEMS---------------------------------------------------------------------------------------------
    public boolean addProductToCart(Cart cart, Product product, int quantity){
        if(quantityValid(quantity) && product != null && cart != null){
            cart.getCartProducts().add(new CartProduct(product, quantity));
            return true;
        }
        return false;
    }
    //Select items: Check quantity
    private boolean quantityValid(int quantity){
        if(quantity>0){
            return true;
        }
        return false;
    }
    //Select items: Check amount of products
    private boolean productsExistInCart(Cart cart){
        if(cart.getCartProducts().size()>0){
            return true;
        }
        return false;
    }

    //MAKE ORDER----------------------------------------------------------------------------------------------
    public boolean makeOrder(Customer customer, DeliveryMethod deliveryMethod, Date deliveryDate){
        if(customer != null && deliveryMethod != null && enoughMoney(customer) && productsExistInCart(customer.getCart())){
            OrderInfo orderInfo = new OrderInfo(customer.getCart(), deliveryMethod, deliveryDate);
            customer.getOrderInfos().add(orderInfo);
            db.orderInfos.add(orderInfo);
            customer.getCart().getCartProducts().clear();
            customer.getBankAccount().setMoney(customer.getBankAccount().getMoney()-orderInfo.TotalPrice());
            return true;
        }
        return false;
    }
    //Make order: Check enough money
    private boolean enoughMoney(Customer customer){
        if(customer.getBankAccount().getMoney()>=customer.getCart().TotalPrice()){
            return true;
        }
        return false;
    }

    //PROCESS ORDER---------------------------------------------------------------------------------------------
    //Process order: Get all "ordered" Order infos
    public List<OrderInfo> orderedOrderedInfos(){
        List<OrderInfo> orderedList = new ArrayList<>();
        for (OrderInfo info: db.orderInfos){
            if(info.getStatus().equals(OrderStatus.Ordered)){
                orderedList.add(info);
            }
        }
        return orderedList;
    }
    //Process order: Get selected order info
    public OrderInfo getOrderInfo(int id){
        for (OrderInfo orderInfo: db.orderInfos){
            if(orderInfo.getId()==id){
                return orderInfo;
            }
        }
        return null;
    }
    //Process order: Get selected ordered product
    public CartProduct getCartProduct(int id, Cart cart){
        for (CartProduct cartProduct: cart.getCartProducts()){
            if(cartProduct.getId()==id){
                return cartProduct;
            }
        }
        return null;
    }
    //Process order: Check product amount
    public boolean sufficientProductAmount(CartProduct cartProduct){
        if(cartProduct.getQuantity() >= cartProduct.getProduct().getAvailableAmount()){
            return true;
        }
        return false;
    }
    //Process order: Change amount of product
    public void reservedProduct(Cart cart){
        for (CartProduct product: cart.getCartProducts()){
            product.getProduct().readyProduct(product.getQuantity());
        }
    }
    //Process order: Ready order
    public boolean readyOrder(OrderInfo orderInfo){
        if(orderInfo!=null&& orderInfo.getStatus().equals(OrderStatus.Ordered)){
            reservedProduct(orderInfo.getCart());
            orderInfo.setStatus(OrderStatus.Ready);
            return true;
        }
        return false;
    }

    //SHIP ORDER------------------------------------------------------------------------------------------------
    //Ship order: Get all "ready" Order infos
    public List<OrderInfo> readyOrderedInfos(){
        List<OrderInfo> orderedList = new ArrayList<>();
        for (OrderInfo info: db.orderInfos){
            if(info.getStatus().equals(OrderStatus.Ready)){
                orderedList.add(info);
            }
        }
        return orderedList;
    }
    //Ship order: Change amount of product
    public void shipProduct(Cart cart){
        for (CartProduct product: cart.getCartProducts()){
            product.getProduct().shipProduct(product.getQuantity());
        }
    }
    //Ship order: Ship order
    public boolean shipOrder(OrderInfo orderInfo){
        if(orderInfo!=null && orderInfo.getStatus().equals(OrderStatus.Ready)){
            shipProduct(orderInfo.getCart());
            orderInfo.setStatus(OrderStatus.Shipped);
            return true;
        }
        return false;
    }

    //VIEW STOCK----------------------------------------------------------------------------------------------
    public List<Product> getProducts(){
        return db.products;
    }
}
