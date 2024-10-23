package Controller;

import Model.RamItems;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class RAMManagementSystem {

    List<RamItems> ramItems = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Validator va = new Validator();
    TypeBusMenuBrand typeBMB = new TypeBusMenuBrand();
    Sort sort = new Sort();
    Search search = new Search(ramItems);

    public void addRamItem() {
        loadFromFile("C:\\Users\\ADMIN\\Desktop\\Laptop RAM Management file gan hoan thien\\RAMModules.dat");
        boolean continueAdding = true;

        while (continueAdding) {
            String type = typeBMB.TypeMenu();

            String code = va.generateUniqueRAMCode(type, ramItems.size());

            String bus = typeBMB.BusMenu();

            String brand = typeBMB.BrandMenu();

            int quantity = va.getInt("Enter RAM Quantity:");

            String productionMonthYear = va.getDate();

            RamItems newRAM = new RamItems(code, type, bus, brand, quantity, productionMonthYear);
            ramItems.add(newRAM);

            System.out.println("RAM item added successfully.");

            if (va.confirmYesNo("Do you want to add another RAM item? --- ( Y/N ) ")) {
                continueAdding = true;
            } else {
                continueAdding = false;
            }
        }

        System.out.println("Press Enter to go back to the main menu !");
        sc.nextLine();
    }

    public void searchSubMenu() {
        int searchChoice = 0;
        do {
            search.displaySearchMenu();
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty! Please enter a valid option.");
                continue;
            }

            try {
                searchChoice = Integer.parseInt(input);

                switch (searchChoice) {
                    case 1:
                        search.searchByType();
                        break;
                    case 2:
                        search.searchByBus();
                        break;
                    case 3:
                        search.searchByBrand();
                        break;
                    case 4:
                        System.out.println("Press Enter to go back to the main menu.");
                        sc.nextLine();
                        break;
                    default:
                        System.out.println("Invalid option! Please choose again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                searchChoice = -1;
            }
        } while (searchChoice != 4);
    }

    public boolean searchRamByCode(String code) {
        for (RamItems item : ramItems) {
            if (item.getCode().equalsIgnoreCase(code) && item.isActive()) {
                return true;
            }
        }
        return false;
    }

   public void updateRamItem() {
        loadFromFile("C:\\Users\\ADMIN\\Desktop\\Laptop RAM Management file gan hoan thien\\RAMModules.dat");
    
        System.out.print("Enter RAM code to update: ");
        String codeToUpdate = sc.nextLine().trim();
    
        RamItems currentRam = null;
        for (RamItems item : ramItems) {
            if (item.getCode().equalsIgnoreCase(codeToUpdate)) {
                currentRam = item;
                break;
            }
        }
    
        if (currentRam == null) {
            System.out.println("RAM item does not exist.");
            System.out.println("Press Enter to go back to the main menu.");
            sc.nextLine();
            return;
        }
    
        System.out.println("Current RAM Item Details: ");
        System.out.printf("%-15s %-15s %-20s %-15s %-15s %-20s %-10s%n", "Code", "Type", "Bus Speed", "Brand", "Quantity", "Production Date", "Active");
        System.out.printf("%-15s %-15s %-20s %-15s %-15d %-20s %-10b%n", currentRam.getCode(), currentRam.getType(), currentRam.getBus(), currentRam.getBrand(), currentRam.getQuantity(), currentRam.getProductionMonthYear(), currentRam.isActive());

        va.updateType(currentRam);
        va.updateBus(currentRam);
        va.updateBrand(currentRam);
        va.updateQuantity(currentRam);
        va.updateProductionDate(currentRam);
    
        System.out.print("Do you want to change the active status? (Current: " + currentRam.isActive() + ") (Y/N): ");
        String changeActive = sc.nextLine().trim();
    
        if (changeActive.equalsIgnoreCase("Y")) {
            currentRam.setActive(!currentRam.isActive());
            System.out.println("Active status changed to: " + currentRam.isActive());
        }
    
        System.out.println("RAM item updated successfully.");
        System.out.println("Press Enter to go back to the main menu.");
        sc.nextLine();
    }
    
    public void delete() {
        loadFromFile("C:\\Users\\ADMIN\\Desktop\\Laptop RAM Management file gan hoan thien\\RAMModules.dat");
    
        System.out.print("Enter the RAM code to delete: ");
        String codeToDelete = sc.nextLine().trim();
    
        RamItems ramToDelete = null;
        for (RamItems item : ramItems) {
            if (item.getCode().equalsIgnoreCase(codeToDelete)) {
                ramToDelete = item;
                break;
            }
        }
        if (ramToDelete == null) {
            System.out.println("RAM item does not exist.");
            System.out.println("Press Enter to go back to the main menu.");
            sc.nextLine();
            return;
        }
    
        if (!ramToDelete.isActive()) {
            System.out.println("The RAM item is already inactive (out of stock).");
            System.out.println("Press Enter to go back to the main menu.");
            sc.nextLine();
            return;
        }

        System.out.print("Are you sure you want to delete this RAM item? (Y/N): ");
        String confirmation = sc.nextLine().trim();
    
        if (confirmation.equalsIgnoreCase("Y")) {
            ramToDelete.setActive(false);
            System.out.println("The RAM item has been marked as ( INACTIVE ).");
        } else {
            System.out.println("Deletion canceled.");
        }
        System.out.println("Press Enter to go back to the main menu.");
        sc.nextLine();
    }
    
        // show hết ram kể cả inactive.
//    public void showAllItems() {
//     if (ramItems.isEmpty()) {
//         System.out.println("No RAM items to display.");
//         System.out.println("Press Enter to go back to the main menu.");
//         sc.nextLine();
//         return;
//     }

//     ramItems.sort(sort.sortByTypeBusBrand());

//     System.out.println("========== Sorted RAM Item Details ==========");
//     System.out.printf("%-15s %-15s %-20s %-15s %-15s %-20s %-10s%n", "Code", "Type", "Bus Speed", "Brand", "Quantity", "Production Date", "Active");

//     for (RamItems item : ramItems) {
//         String activeStatus;

//         if (item.isActive()) {
//             activeStatus = "True";
//         } else {
//             activeStatus = "False";
//         }

//         System.out.printf("%-15s %-15s %-20s %-15s %-15d %-20s %-10s%n", 
//             item.getCode(), item.getType(), item.getBus(), item.getBrand(), 
//             item.getQuantity(), item.getProductionMonthYear(), activeStatus);
//     }

//     System.out.println("Press Enter to go back to the main menu.");
//     sc.nextLine();
// }


//show hết thông tin bỏ qua in

public void showAllItems() {
    List<RamItems> activeItems = new ArrayList<>();

    for (RamItems item : ramItems) {
        if (item.isActive()) {
            activeItems.add(item);
        }
    }

    if (activeItems.isEmpty()) {
        System.out.println("No active RAM items to display.");
        System.out.println("Press Enter to go back to the main menu.");
        sc.nextLine();
        return;
    }

    activeItems.sort(sort.sortByTypeBusBrand());

    System.out.println("========== Sorted RAM Item Details ==========");
    System.out.printf("%-15s %-15s %-20s %-15s %-15s %-20s %-10s%n", "Code", "Type", "Bus Speed", "Brand", "Quantity", "Production Date", "Active");

    for (RamItems item : activeItems) {
        System.out.printf("%-15s %-15s %-20s %-15s %-15d %-20s %-10s%n", item.getCode(), item.getType(), item.getBus(), item.getBrand(), item.getQuantity(), item.getProductionMonthYear(), item.isActive());
    }

    System.out.println("Press Enter to go back to the main menu.");
    sc.nextLine();
}


////
    public void loadFromFile(String path) {
        List<RamItems> list = new ArrayList<>();
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File not found: " + path);
        }

        try (
            Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] arr = data.split(", ");
                RamItems ram = new RamItems(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), arr[5]);
                list.add(ram);
            }
        } catch (Exception e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }

    public void saveToFile(boolean isExiting) {
        if (ramItems.isEmpty()) {
            System.out.println("RAM items list is empty. Nothing to save.");
            if (!isExiting) {
                System.out.println("Press Enter to go back to the main menu.");
                sc.nextLine();
            }
            return;
        }

        try (
                PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\ADMIN\\Desktop\\Laptop RAM Management file gan hoan thien\\RAMModules.dat"))) {
            for (RamItems r : ramItems) {
                pw.println(r.getCode() + ", " + r.getType() + ", " + r.getBus() + ", " + r.getBrand() + ", " + r.getQuantity() + ", " + r.getProductionMonthYear());
            }
            System.out.println("Successfully saved to file.");
            System.out.println("Press Enter to go back to the main menu.");
        } catch (Exception e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }

        if (!isExiting) {
            System.out.println("Press Enter to go back to the main menu.");
            sc.nextLine();
        }
    }

    public boolean quitProgram() {
        if (va.confirmYesNo("Do you want to exit? --- ( Y/N ) ")) {
            if (!ramItems.isEmpty()) {
                saveToFile(true);
            } else {
                System.out.println("RAM items list is empty. Nothing to save!");
            }
            System.out.println("Goodbye!");
            return false;
        } else {
            System.out.println("Press Enter to go back to the main menu.");
            sc.nextLine();
            return true;
        }
    }

}
