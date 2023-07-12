package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        Admin admin = new Admin();
        Customer customer= new Customer();

        store.setProducts("apple", 5.2F);
        store.setProducts("banana",3.8F);
        store.setProducts("apple",4.9F);

        System.out.println(admin.products);
        System.out.println(customer.products);
    }
}

abstract class Observer{
    Manger manger;
    Map<String,Float> products;

    public abstract void update(String product,float price);
}

class Admin extends Observer{
    public Admin() {
        manger = Manger.getInstance();
        products = new HashMap<>();
        manger.attach(this);
    }

    @Override
    public void update(String product, float price) {
        products.put(product,price);
    }
}

class Customer extends Observer{
    public Customer() {
        manger = Manger.getInstance();
        products = new HashMap<>();
        manger.attach(this);
    }

    @Override
    public void update(String product, float price) {
        products.put(product,price);
    }
}

class Manger {
    private List<Observer> observers = new ArrayList<>();
    private static final Manger instance = new Manger();

    public static Manger getInstance() {
        return instance;
    }

    public void setProduct(String product,float price){
        observers.forEach(observer -> {
            observer.update(product,price);
        });
    }

    public void attach(Observer observer){
        observers.add(observer);
    }
}

class Store {
    private Map<String,Float> products;
    private Manger manger;

    public Store(){
        products = new HashMap<>();
        manger = Manger.getInstance();
    }

    public void setProducts(String product,float price) {
        products.put(product,price);
        manger.setProduct(product,price);
    }
}