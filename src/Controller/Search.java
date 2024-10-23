package Controller;

import Model.RamItems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Search {

    List<RamItems> ramItems = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Search(List<RamItems> ramItems) {
        this.ramItems = ramItems;
    }

    public void displaySearchMenu() {
        System.out.println("========== Search RAM Items ==========");
        System.out.println("1. Search by Type");
        System.out.println("2. Search by Bus");
        System.out.println("3. Search by Brand");
        System.out.println("4. Return to Main Menu");
        System.out.print("Choose an option (1-4): ");
    }

    public void searchByType() {
        List<RamItems> result = new ArrayList<>();
        System.out.print("Enter RAM type to search:");
        String searchType = sc.nextLine().trim();

        for (RamItems product : ramItems) {
            if (product.getType().equalsIgnoreCase(searchType) && product.isActive()) {
                result.add(product);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No RAM found with the type.");
        } else {
            System.out.println("List of RAM modules found by type:");
            System.out.printf("%-15s %-15s %-20s %-15s%n", "Code", "Type", "Production Date", "Quantity");
            for (RamItems product : result) {
                System.out.printf("%-15s %-15s %-20s %-15d%n", product.getCode(), product.getType(), product.getProductionMonthYear(), product.getQuantity());
            }
        }

        System.out.println("Press Enter to go back to the main menu.");
        sc.nextLine();
    }

    public void searchByBus() {
        List<RamItems> result = new ArrayList<>();
        System.out.print("Enter RAM bus speed to search: ");
        String searchBus = sc.nextLine().trim();

        for (RamItems product : ramItems) {
            if (product.getBus().equalsIgnoreCase(searchBus) && product.isActive()) {
                result.add(product);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No RAM found with the bus speed.");
        } else {
            System.out.println("List of RAM modules found by bus speed:");
            System.out.printf("%-15s %-15s %-20s %-15s%n", "Code", "Bus", "Production Date", "Quantity");
            for (RamItems product : result) {
                System.out.printf("%-15s %-15s %-20s %-15d%n", product.getCode(), product.getBus(), product.getProductionMonthYear(), product.getQuantity());
            }
        }

        System.out.println("Press Enter to go back to the main menu.");
        sc.nextLine();
    }

    public void searchByBrand() {
        List<RamItems> result = new ArrayList<>();
        System.out.print("Enter RAM brand to search: ");
        String searchBrand = sc.nextLine().trim();

        for (RamItems product : ramItems) {
            if (product.getBrand().equalsIgnoreCase(searchBrand) && product.isActive()) {
                result.add(product);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No RAM found with the brand.");
        } else {
            System.out.println("List of RAM modules found by brand:");
            System.out.printf("%-15s %-15s %-20s %-15s%n", "Code", "Brand", "Production Date", "Quantity");
            for (RamItems product : result) {
                System.out.printf("%-15s %-15s %-20s %-15d%n", product.getCode(), product.getBrand(), product.getProductionMonthYear(), product.getQuantity());
            }
        }

        System.out.println("Press Enter to go back to the main menu.");
        sc.nextLine();
    }

}
