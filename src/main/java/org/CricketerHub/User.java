package org.CricketerHub;

import java.util.Scanner;

import static org.CricketerHub.Cricketer.getNumberOfCricketers;

// ..........................................
// Assignment # 0!
// © Srujana Guttula
// Written by: Srujana Guttula - 40237663
// ..........................................

/**
 * This class handles all the implementations of user operations
 */
public class User {
    private static final String PASSWORD  = "password";
    private static final int MAX_WRONG_ATTEMPTS = 12;
    private int maxWrongAttempts;
    private Cricketer[] cricketerDatabase;

    User(){
        this.maxWrongAttempts = 0;
    }

    /**
     * Setter method to set the cricketerDatabase array
     * @param cricketerDatabase cricketerDatabase array
     */
    public void setCricketerDatabase(Cricketer[] cricketerDatabase){
        this.cricketerDatabase = cricketerDatabase;
    }

    /**
     * Checks user input with the constant value - password
     * @param password user input
     * @return true if password is correct
     */
    public boolean checkPassword(String password){
        return password.equals(PASSWORD);
    }

    /**
     * This method check if there's a suspicious activity
     * @return true if max attempts are reached
     */
    public boolean  suspiciousActivity(){
        return maxWrongAttempts >= MAX_WRONG_ATTEMPTS;
    }

    /**
     * This method validates the password entered by the user
     * @return true if the password is valid
     */
    public boolean login(){
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        int wrongAttempts = 0;

        while (!suspiciousActivity()) {
            String password = scanner.nextLine();
            if(checkPassword(password)){
                isLoggedIn = true;
                break;
            }
            else {
                maxWrongAttempts ++;
                if(wrongAttempts < 2){
                    wrongAttempts++;
                    System.out.println("Invalid password," + (3 - wrongAttempts) + " attempts remaining.");
                }
                else{
                    System.out.println("\u001B[31mInvalid password, returning to main menu.\u001B[0m\n" );
                    if(suspiciousActivity()){
                        System.out.println("\u001B[1m\u001B[31mProgram detected suspicious activities and will terminate immediately!\u001B[0m");
                        System.exit(0);
                    }
                    break;
                }
            }
        }
        return isLoggedIn;
    }

    /**
     * This method performs initial check to add the user
     * Lets the user know how many players they can add based on the space available
     */
    public void addCricketer(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many cricketers do you want to add?");
        int cricketers = scanner.nextInt();

        //get the available space in the array
        int availableCapacity = checkDatabaseCapacity();

        //do not add players if maximum limit is reached
        if(availableCapacity == 0)
            System.out.println("The maximum number of cricketers your organization can handle is " + cricketerDatabase.length + "\nYou have reached max capacity");

        //add all the players if enough space in the array
        else if(availableCapacity >= cricketers) {
            System.out.println("You can add " + cricketers + " player to the database");
            addCricketerDetails(cricketers);
        }

        //add players based on the availability
        else {
            System.out.println("You can only add " + availableCapacity + "players to the database");
        }
    }

    /**
     * This method prompts the user to enter Cricketer details
     * Creates cricketer object and adds it to cricketerDatabase array
     * @param count available space in the cricketerDatabase array
     */
    public void addCricketerDetails(int count){
        Scanner scanner = new Scanner(System.in);
        long cricketerId;
        String cricketerName;
        float battingAvg;
        float bowlingAvg;
        float strikeRate;
        float economyRate;
        boolean isAvailable;

        for (int i = 0; i < count; i++) {
            boolean validInput = false;
            //Handle Input Mismatch exception
            while (!validInput) {
                try {
                    System.out.println("Enter details for cricketer " + (i+1));

                    System.out.println("CricketerID:");
                    cricketerId = Long.parseLong(scanner.nextLine());
                    System.out.println("Cricketer Name:");
                    cricketerName = scanner.nextLine();
                    System.out.println("Batting Average:");
                    battingAvg = Float.parseFloat(scanner.nextLine());
                    System.out.println("Bowling Average:");
                    bowlingAvg = Float.parseFloat(scanner.nextLine());
                    System.out.println("Strike Rate:");
                    strikeRate = Float.parseFloat(scanner.nextLine());
                    System.out.println("Economy Rate:");
                    economyRate = Float.parseFloat(scanner.nextLine());
                    System.out.println("isAvailable?(true/false)");
                    isAvailable = Boolean.parseBoolean(scanner.nextLine());

                    Cricketer cricketer = new Cricketer(cricketerId, cricketerName, battingAvg, bowlingAvg, strikeRate, economyRate, isAvailable);

                    //Add cricketer object to cricketerDatabase array
                    cricketerDatabase[getNumberOfCricketers() - 1] = cricketer;
                    System.out.println("Added cricketer " + cricketerName + " to the database\n");
                    validInput = true;

                } catch (Exception e) {
                    System.out.println("Error adding player "+ + (i+1) +" check the input " );
                }
            }
        }
    }

    /**
     * This method checks for space in the array
     * @return the available space in the cricketerDatabase array
     */
    public int checkDatabaseCapacity(){
        return cricketerDatabase.length - getNumberOfCricketers();
    }

    /**
     * This method performs initial check to update a cricketer Attribute
     * Checks if cricketer exists in the database
     * If not prompts the user to enter a valid cricketer ID
     */
    public void updateCricketer(){
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter Cricketer ID or 'quit' to go back to the main menu ");
            String input = scanner.nextLine();
            if(input.equals("quit"))
                break;

            try {
                long cricketerId = Long.parseLong(input);
                Cricketer targetCricketer = null;

                for( int i = 0 ; i < getNumberOfCricketers() ; i++ ){
                    if (cricketerDatabase[i] != null && cricketerDatabase[i].getCricketerId() == cricketerId) {
                        targetCricketer = cricketerDatabase[i];
                        index = i;
                        break;
                    }
                }

                if (targetCricketer != null) {
                    System.out.println("Cricketer : " + index + "\n" + targetCricketer);
                    updateCricketerDetails(targetCricketer,index);
                } else {
                    System.out.println("Cricketer not found.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a valid Cricketer ID or 'quit' to go back to the main menu.");
            }
        }
    }

    /**
     * This method prompts the user to enter the changes they would like to make
     * @param targetCricketer cricketer Object
     * @param index index of cricketer object in the cricketerDatabase array
     */
    public void updateCricketerDetails(Cricketer targetCricketer, int index)
    {
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        while(valid) {
            System.out.println("\nCricketer : " + index + "\n" + targetCricketer +"\n");
            System.out.println("What information would you like to change? \n" +
                    "1. Name \n" +
                    "2. Batting Average \n" +
                    "3. Bowling Average \n" +
                    "4. Strike Rate \n" +
                    "5. Economy \n" +
                    "6. Availability \n" +
                    "7. Quit \n" +
                    "Enter your choice >");

            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("Enter the new Name");
                        targetCricketer.setCricketerName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter new Batting Average");
                        targetCricketer.setBattingAvg(scanner.nextFloat());
                        break;
                    case 3:
                        System.out.println("Enter new Bowling Average");
                        targetCricketer.setBowlingAvg(scanner.nextFloat());
                        break;
                    case 4:
                        System.out.println("Enter new Strike Rate");
                        targetCricketer.setStrikeRate(scanner.nextFloat());
                        break;
                    case 5:
                        System.out.println("Enter new Economy");
                        targetCricketer.setEconomyRate(scanner.nextFloat());
                        break;
                    case 6:
                        System.out.println("Enter new Availability");
                        targetCricketer.setAvailable(scanner.nextBoolean());
                        break;
                    case 7:
                        System.out.println("Exiting edit mode for cricketer!" +targetCricketer.getCricketerId());
                        valid = false;
                        break;
                    default:
                        System.out.println("Invalid Input, enter a number between 1 and 7.");
                        break;
                }
            }

            else {
                System.out.println("Invalid Input. Please Enter a number between 1 and 7.\n");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }
    }
}

