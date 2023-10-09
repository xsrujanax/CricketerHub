package org.CricketerHub;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int maxCricketers = 0;
        int input = 0 ;

        System.out.println("\u001B[1mWelcome to CricketerHub!\u001B[0m");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the maximum number of Cricketers your organization can manage.");
        maxCricketers = scanner.nextInt();
        scanner.nextLine();
        while(true){
            System.out.println("What do you want to do? \n" +
                    "1. Enter new Cricketers (password required). \n" +
                    "2. Change information of a Cricketer (password required). \n" +
                    "3. Display available Cricketers with a bowlingAvg greater than user value. \n" +
                    "4. Display all Cricketers that can play as an AllRounder. \n" +
                    "5. Quit \n" +
                    "Please enter your choice >");
            if(scanner.hasNextInt()) {
                input = scanner.nextInt();
                switch (input){
                    case 1 :
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.println("Closing the Application. Goodbye!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\u001B[31mInvalid Input. Please Enter a number between 1 and 5.\u001B[0m\n");
                }
            }
            else {
                System.out.println("Invalid Input. Please Enter a number between 1 and 5.\n");
                scanner.nextLine();
            }
        }
    }
}