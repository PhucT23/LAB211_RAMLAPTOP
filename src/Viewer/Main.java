package Viewer;

import java.util.Scanner;
import Controller.RAMManagementSystem;
import Controller.Search;
import Controller.Validator;

public class Main {

    Validator va = new Validator();

    public static void Menu() {
        System.out.println("========== RAM Management System ==========");
        System.out.println("||          1. Add RAM Item              ||");
        System.out.println("||          2. Search SubMenu            ||");
        System.out.println("||          3. Update Item Information   ||");
        System.out.println("||          4. Delete Item               ||");
        System.out.println("||          5. Show All Items            ||");
        System.out.println("||          6. Store Data to Files       ||");
        System.out.println("||          7. Quit Menu.                ||");
        System.out.println("===================END=====================\n");
    }

    public static void main(String[] args) {
        RAMManagementSystem ramManager = new RAMManagementSystem();
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        int choice = 0;
        do {
            Menu();
            validInput = false;
            while (!validInput) {
                System.out.print("Please choose an option: ");
                try {
                    choice = Integer.parseInt(sc.nextLine());
                    if (choice >= 1 && choice <= 7) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid choice! Please select a number between 1 and 7.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                }
            }
            
            switch (choice) {
                case 1:
                    ramManager.addRamItem();
                    break;
                case 2:
                    ramManager.searchSubMenu();
                    break;
                case 3:
                    ramManager.updateRamItem();
                    break;
                case 4:
                    ramManager.delete();
                    break;
                case 5:
                    ramManager.showAllItems();
                    break;
                case 6:
                    ramManager.saveToFile(true);
                    sc.nextLine();
                    break;
                case 7:
                    if (!ramManager.quitProgram()) {
                        return;
                    }
                    break;
                default:
                    System.out.println("Please enter again!");
                    break;
            }
        } while (true);
    }
}
