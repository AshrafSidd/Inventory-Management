package backend;

import java.io.Serializable;

public class Product implements Serializable {

    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name, int quantity, double price) {

        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void displayProduct() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);

        if(quantity < 10 && quantity > 0) {
            System.out.println("LOW STOCK");
        }

        if(quantity == 0) {
            System.out.println("OUT OF STOCK");
        }

        System.out.println("----------------------");
    }

    public void updateQuantity(int newQuantity) {
        quantity = newQuantity;
    }
}