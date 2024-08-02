package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_managment", "intern", "Intern@20038");
            ItemManager itemManager = new ItemManager(connection);
            StoreManager storeManager = new StoreManager(connection);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter operation (insertItem, findItem, findItemsByName, insertStore, findStore): ");
            String operation = scanner.nextLine().toLowerCase();

            switch (operation) {
                case "insertitem":
                    System.out.println("Enter item code: ");
                    String itemCode = scanner.nextLine();
                    System.out.println("Enter item name: ");
                    String itemName = scanner.nextLine();
                    itemManager.insertItem(itemCode, itemName);
                    break;

                case "finditem":
                    System.out.println("Enter item code: ");
                    String findItemCode = scanner.nextLine();
                    item item = itemManager.findItem(findItemCode);
                    if (item != null) {
                        System.out.println("Item found: " + item.getName());
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case "finditemsbyname":
                    System.out.println("Enter item name: ");
                    String searchName = scanner.nextLine();
                    itemManager.findItemsByNameContains(searchName).forEach(i -> {
                        System.out.println("Item found: " + i.getItemCode() + i.getName());
                    });
                    break;

                case "insertstore":
                    System.out.println("Enter store code: ");
                    String storeCode = scanner.nextLine();
                    System.out.println("Enter store name: ");
                    String storeName = scanner.nextLine();
                    storeManager.insertStore(storeCode, storeName);
                    break;

                case "findstore":
                    System.out.println("Enter store code: ");
                    String findStoreCode = scanner.nextLine();
                    Store store = storeManager.findStore(findStoreCode);
                    if (store != null) {
                        System.out.println("Store found: " + store.getName() );
                    } else {
                        System.out.println("Store not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid operation.");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
