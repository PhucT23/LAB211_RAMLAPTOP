package Controller;

import Model.RamItems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Validator {

    UpdateTypeBusBrand upTBB = new UpdateTypeBusBrand();
    Scanner sc = new Scanner(System.in);
    TypeBusMenuBrand typeBM = new TypeBusMenuBrand();

    public static String generateUniqueRAMCode(String type, int count) {
        return String.format("RAM%s_%d", type, count + 1);
    }

    public static String getString(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = new Scanner(System.in).nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter again.");
            }
        } while (input.isEmpty());
        return input;
    }

    public static int getInt(String prompt) {
        int result = 0;
        boolean valid = false;
        while (!valid) {
            try {
                String input = getString(prompt);
                result = Integer.parseInt(input);
                if (result > 0) {
                    valid = true;
                } else {
                    System.out.println("Quantity must be positive. Please enter again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return result;
    }

    public static boolean isValidDate(String date) {
        return date.matches("\\d{2}/\\d{4}");
    }

    public static String getDate() {
        String date = null;
        boolean valid = false;

        while (!valid) {
            date = getString("Enter production date (format: MM/YYYY): ");

            if (date == null || date.isEmpty()) {
                System.out.println("Date cannot be empty. Please enter again.");
                continue;
            }

            if (isValidDate(date)) {
                String[] parts = date.split("/");
                int month = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);

                boolean hasError = false;

                if (year < 0 || year > 2024) {
                    System.out.println("Year must be between 0 and 2024. Please enter again.");
                    hasError = true;
                }

                if (month < 1 || month > 12) {
                    System.out.println("Month must be between 01 and 12. Please enter again.");
                    hasError = true;
                }

                if (!hasError) {
                    valid = true;
                }

            } else {
                System.out.println("Invalid date format. Please enter in MM/YYYY format.");
            }
        }

        return date;
    }

    public static boolean confirmYesNo(String prompt) {
        String choice;
        while (true) {
            choice = getString(prompt);
            if (choice.equalsIgnoreCase("y")) {
                return true;
            } else if (choice.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Invalid choice. Please enter 'y' for Yes or 'n' for No.");
            }
        }
    }

    public void updateType(RamItems ramItem) {
        String currentType = ramItem.getType();
        while (true) {
            String newType = upTBB.updateType();
            if (newType.isEmpty()) {
                System.out.println("RAM Type remains unchanged.");
                break;
            } else if (!newType.equals(currentType)) {
                ramItem.setType(newType);
                break;
            } else {
                System.out.println("Invalid or same as current type. Please enter a new RAM type.");
            }
        }
    }

    public void updateBus(RamItems ramItem) {
        String currentBus = ramItem.getBus();

        while (true) {
            String newBus = upTBB.updateBus();
            if (newBus.isEmpty()) {
                System.out.println("Bus Speed remains unchanged.");
                break;
            } else if (!newBus.equals(currentBus)) {
                ramItem.setBus(newBus);
                break;
            } else {
                System.out.println("Invalid or same as current bus speed. Please enter a new bus speed.");
            }
        }
    }

    public void updateBrand(RamItems ramItem) {
        String currentBrand = ramItem.getBrand();

        while (true) {
            System.out.print("Enter new RAM Brand: ");
            String newBrand = upTBB.updateBrand();

            if (newBrand.isEmpty()) {
                System.out.println("RAM Brand remains unchanged.");
                break;
            } else if (!newBrand.equals(currentBrand)) {
                ramItem.setBrand(newBrand);
                break;
            } else {
                System.out.println("Invalid or same as current brand. Please enter a new RAM brand.");
            }
        }
    }

    public void updateQuantity(RamItems ramItem) {
        int currentQuantity = ramItem.getQuantity();
        while (true) {
            System.out.print("Enter new RAM Quantity: ");
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("RAM Quantity remains unchanged.");
                break;
            } else {
                try {
                    int newQuantity = Integer.parseInt(input);
                    if (newQuantity > 0) {
                        ramItem.setQuantity(newQuantity);
                        break;
                    } else {
                        System.out.println("Please enter a positive number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }
    }

    public void updateProductionDate(RamItems ramItem) {
        String currentDate = ramItem.getProductionMonthYear();

        while (true) {
            System.out.print("Enter new Production Month/Year (MM/YYYY): ");
            String newProductionDate = sc.nextLine();

            if (newProductionDate.isEmpty()) {
                System.out.println("Production date remains unchanged.");
                break;
            }

            if (isValidDate(newProductionDate)) {
                String[] parts = newProductionDate.split("/");
                int month = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                boolean valid = true;
                if (year < 0 || year > 2024) {
                    System.out.println("Year must be between 0 and 2024. Please enter again.");
                    valid = false;
                }
                if (month < 1 || month > 12) {
                    System.out.println("Month must be between 01 and 12. Please enter again.");
                    valid = false;
                }
                if (valid) {
                    ramItem.setProductionMonthYear(newProductionDate);
                    break;
                }
            } else {
                System.out.println("Invalid date format. Please enter in MM/YYYY format.");
            }
        }
    }

    public String getDeleteString(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine();
        if (input.isEmpty()) {
        }
        return input;
    }

}
