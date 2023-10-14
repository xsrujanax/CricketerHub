package org.CricketerHub;

import java.util.Scanner;

/**
 * The main class for the CricketerHub application.
 */
public class Main {
    /**
     * The entry point for the CricketerHub application.
     * @param args The command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("**-----------------------------------------------------**");
        System.out.println("\t\t\t\t\u001b[1mWelcome to CricketerHub!\u001b[0m");
        System.out.println("**-----------------------------------------------------**\n");
        System.out.println("Enter the maximum number of Cricketers your organization can manage.");
        Cricketer[] cricketerDatabase = new Cricketer[scanner.nextInt()];
        user.setCricketerDatabase(cricketerDatabase);
        scanner.nextLine();
        while(true) {
            System.out.println("\nWhat do you want to do? \n1. Enter new Cricketers (password required). \n2. Change information of a Cricketer (password required). \n3. Display available Cricketers with a bowlingAvg greater than user value. \n4. Display all Cricketers that can play as an AllRounder. \n5. Quit \nPlease enter your choice >");
            if (scanner.hasNextInt()) {
                int inputValue = scanner.nextInt();
                scanner.nextLine();
                switch (inputValue) {
                    case 1:
                        System.out.println("Enter password");
                        if (user.login()) {
                            user.addCricketer();
                        }
                        break;
                    case 2:
                        System.out.println("Enter password");
                        if (user.login()) {
                            user.updateCricketer();
                        }
                        break;
                    case 3:
                        System.out.println("Enter the desired maximum bowling average");
                        findCricketersBy(scanner.nextFloat(),cricketerDatabase);
                        break;
                    case 4:
                        System.out.println("Enter the strike rate and economy rate");
                        findAllRounders(scanner.nextFloat(), scanner.nextFloat(),cricketerDatabase);
                        break;
                    case 5:
                        System.out.println("Closing the Application. Goodbye!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\u001b[31mInvalid Input. Please Enter a number between 1 and 5.\u001b[0m\n");
                }
            } else {
                System.out.println("Invalid Input. Please Enter a number between 1 and 5.\n");
            }
        }
    }

    /**
     * Find and display cricketers with a bowling average less than the specified value.
     * @param bowlingAverage The maximum bowling average.
     * @param cricketerDatabase The database of cricketers.
     */
    public static void findCricketersBy(float bowlingAverage, Cricketer[] cricketerDatabase){
        int count = 0;
        for (Cricketer cricketer : cricketerDatabase) {
            if (cricketer != null && cricketer.getBowlingAvg() < bowlingAverage) {
                System.out.println("\n" + cricketer);
                count++;
            }
        }
        if(count == 0)
            System.out.println("No players below maximum bowling average.");
    }

    /**
     * Find and display all-rounders based on specified strike rate and economy rate.
     * @param strikeRate The minimum strike rate.
     * @param economyRate The maximum economy rate.
     * @param cricketerDatabase The database of cricketers.
     */
    public static void findAllRounders(float strikeRate, float economyRate, Cricketer[] cricketerDatabase){
        int count = 0;
        for (Cricketer cricketer : cricketerDatabase) {
            if (cricketer != null && (cricketer.getStrikeRate() > strikeRate && cricketer.getEconomyRate() <economyRate)) {
                System.out.println("\n" + cricketer);
                count ++;
            }
        }
        if(count == 0)
            System.out.println("No players with mentioned higher striking rate and lower economy rate.");
    }
}
