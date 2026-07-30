package backend;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String... args){
        InventoryService service = new InventoryService();
        Scanner sc = new Scanner(System.in);


        while(true){

            System.out.println("\n===== INVENTORY SYSTEM =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Product");
            System.out.println("3. Search Product");
            System.out.println("4. Update Quantity");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");

            System.out.println("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice){

                case 1:

                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    Product product =
                            new Product(id, name, quantity, price);

                    service.addProduct(product);
                    break;

                case 2:

                    service.viewProducts();

                    break;

                case 3:

                    System.out.print("Enter Product ID to search: ");
                    int searchID = sc.nextInt();
                    service.searchProduct(searchID);

                    break;

                case 4:

                    System.out.print("Enter Product ID: ");
                    int updateID = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQuantity = sc.nextInt();

                    service.updateProductQuantity(updateID, newQuantity);

                    break;

                case 5:

                    System.out.print("Enter Product ID to delete: ");
                    int deleteID = sc.nextInt();

                    service.deleteProduct(deleteID);

                    break;

                case 6:

                    System.out.println("Exiting System...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}
