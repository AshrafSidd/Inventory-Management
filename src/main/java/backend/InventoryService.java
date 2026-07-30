package backend;

import java.io.*;
import java.util.ArrayList;

public class InventoryService {

    ArrayList<Product> inventory;

    public InventoryService() {

        inventory = loadFromFile();
    }

    public void addProduct(Product product) {

        for(Product p : inventory) {

            if(p.getId() == product.getId()) {

                System.out.println("Product ID already exists.");
                return;
            }
        }

        inventory.add(product);

        saveToFile();

        System.out.println("Product Added Successfully!");
    }

    public void viewProducts() {

        if(inventory.isEmpty()) {

            System.out.println("Inventory is empty.");
            return;
        }

        double totalValue = 0;

        for(Product p : inventory) {

            p.displayProduct();

            totalValue += p.getQuantity() * p.getPrice();
        }

        System.out.println("Total Inventory Value: " + totalValue);
    }

    public void searchProduct(int id) {

        for(Product p : inventory) {

            if(p.getId() == id) {

                p.displayProduct();
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void updateProductQuantity(int id, int newQuantity) {

        for(Product p : inventory) {

            if(p.getId() == id) {

                p.updateQuantity(newQuantity);

                saveToFile();

                System.out.println("Quantity Updated!");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void deleteProduct(int id) {

        for(Product p : inventory) {

            if(p.getId() == id) {

                inventory.remove(p);

                saveToFile();

                System.out.println("Product Deleted!");
                return;
            }
        }

        System.out.println("Product not found.");
    }
    
    public void saveToFile() {

        try {

            File file = new File("inventory.dat");

            FileOutputStream fos =
                    new FileOutputStream(file);

            ObjectOutputStream oos =
                    new ObjectOutputStream(fos);

            oos.writeObject(inventory);

            oos.close();

            System.out.println("Saved at: " + file.getAbsolutePath());
        }
        catch(Exception e) {

            e.printStackTrace();
        }
    }

    public ArrayList<Product> loadFromFile() {

        try {

            FileInputStream fis =
                    new FileInputStream("inventory.dat");

            ObjectInputStream ois =
                    new ObjectInputStream(fis);

            return (ArrayList<Product>) ois.readObject();
        }
        catch(Exception e) {

            System.out.println("No previous data found.");

            return new ArrayList<>();
        }
    }
}