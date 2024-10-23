package Controller;

import java.util.Scanner;

public class UpdateTypeBusBrand {
    public static String updateType() {
        Scanner sc = new Scanner(System.in);
        String ramType = "";

        System.out.println(" ========== Select RAM Type Speed ========== ");
        System.out.println("1. DDR4");
        System.out.println("2. LPDDR4");
        System.out.println("3. LPDDR5");
        System.out.println("4. DDR3");
        System.out.println("5. LPDDR3");
        System.out.println("6. Others: Enter the custom type");

        int choice = 0;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.print("Choose option (1-6): ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                return "";
            }

            try {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 6) {
                    validChoice = true;
                } else {
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }

        switch (choice) {
            case 1:
                return "DDR4";
            case 2:
                return "LPDDR4";
            case 3:
                return "LPDDR5";
            case 4:
                return "DDR3";
            case 5:
                return "LPDDR3";
            case 6:
                do {
                    System.out.print("Enter the custom RAM Type: ");
                    ramType = sc.nextLine().trim();
                    if (ramType.isEmpty()) {
                        System.out.println("Custom RAM type cannot be empty. Please enter again.");
                    }
                } while (ramType.isEmpty());
                return ramType;
        }

        return ramType;
    }

    public static String updateBus() {
        Scanner sc = new Scanner(System.in);
        String busSpeed = "";

        System.out.println(" ========== Select RAM Bus Speed ========== ");
        System.out.println("1. 1600MHz");
        System.out.println("2. 2333MHz");
        System.out.println("3. 2666MHz");
        System.out.println("4. 3200MHz");
        System.out.println("5. 4800MHz");
        System.out.println("6. 5600MHz");
        System.out.println("7. Others: Enter the custom bus speed");

        int choice = 0;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.print("Choose option (1-7): ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                return "";
            }

            try {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 7) {
                    validChoice = true;
                } else {
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }

        switch (choice) {
            case 1:
                return "1600MHz";
            case 2:
                return "2333MHz";
            case 3:
                return "2666MHz";
            case 4:
                return "3200MHz";
            case 5:
                return "4800MHz";
            case 6:
                return "5600MHz";
            case 7:
                do {
                    System.out.print("Enter the custom Bus Speed: ");
                    busSpeed = sc.nextLine().trim();
                    if (busSpeed.isEmpty()) {
                        System.out.println("Custom bus speed cannot be empty. Please enter again.");
                    }
                } while (busSpeed.isEmpty());
                return busSpeed;
        }
        return busSpeed;
    }

    public static String updateBrand() {
        Scanner sc = new Scanner(System.in);
        String brandModule = "";

        System.out.println(" ========== Select Brand RAM module ========== ");
        System.out.println("1. Corsair");
        System.out.println("2. G.Skill");
        System.out.println("3. Kingston");
        System.out.println("4. Gigabyte");
        System.out.println("5. Kingmax");
        System.out.println("6. Lexar ");
        System.out.println("7. Others: Enter the Brand RAM");

        int choice = 0;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.print("Choose option (1-6): ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                return "";
            }

            try {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 6) {
                    validChoice = true;
                } else {
                    System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }

        switch (choice) {
            case 1:
                return "DDR4";
            case 2:
                return "LPDDR4";
            case 3:
                return "LPDDR5";
            case 4:
                return "DDR3";
            case 5:
                return "LPDDR3";
            case 6:
                do {
                    System.out.print("Enter the custom Brand RAM: ");
                    brandModule = sc.nextLine().trim();
                    if (brandModule.isEmpty()) {
                        System.out.println("Custom Brand RAM cannot be empty. Please enter again.");
                    }
                } while (brandModule.isEmpty());
                return brandModule;
        }

        return brandModule;
    }

}
