package org.CricketerHub;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private static final String PASSWORD  = "password";
    private static final int MAX_WRONG_ATTEMPTS = 12;
    private int maxWrongAttempts;
    private Cricketer[] cricketerDatabase;

    User(){
        this.maxWrongAttempts = 0;
    }

    public void setCricketerDatabase(Cricketer[] cricketerDatabase){
        this.cricketerDatabase = cricketerDatabase;
    }

    public boolean checkPassword(String password){
        return password.equals(PASSWORD);
    }

    public boolean  suspiciousActivity(){
        return maxWrongAttempts >= MAX_WRONG_ATTEMPTS;
    }

    public boolean login(){
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        int wrongAttempts = 0;

        while (!suspiciousActivity()) {
            if(!isLoggedIn)
            {
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
                            System.out.println("\u001B[31mProgram detected suspicious activities and will terminate immediately!\u001B[0m");
                            System.exit(0);
                        }
                        break;
                    }
                }
            }
        }
        return isLoggedIn;
    }
    public void addCricketer(){
        System.out.println("How many cricketers do you want to add?");
        Scanner scanner = new Scanner(System.in);
        int cricketers = scanner.nextInt();
        int check = checkDatabaseCapacity();
        if(check == 0)
            System.out.println("The maximum number of cricketers your organization can handle is " + cricketerDatabase.length + "\nYou have reached max capacity");
        else if(check >= cricketers) {
            System.out.println("You can successfully add " + cricketers + " to the database");
            addCricketerDetails(cricketers);
        }
        else {
            System.out.println("You can only add " + check + "players to the database");
            addCricketerDetails(check);
        }
    }

    public void addCricketerDetails(int count){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0 ; i < count ; i ++){
            Cricketer cricketer = new Cricketer();
            System.out.println("Enter the CricketerID: ");
            cricketer.setCricketerId(Long.parseLong(scanner.nextLine()));
            System.out.println("Enter the Cricketer Name: ");
            cricketer.setCricketerName(scanner.nextLine());
            System.out.println("Enter the Batting Average: ");
            cricketer.setBattingAvg(Float.parseFloat(scanner.nextLine()));
            System.out.println("Enter the Bowling Average: ");
            cricketer.setBowlingAvg(Float.parseFloat(scanner.nextLine()));
            System.out.println("Enter the Strike Rate: ");
            cricketer.setStrikeRate(Float.parseFloat(scanner.nextLine()));
            System.out.println("Enter the Economy Rate: ");
            cricketer.setEconomyRate(Float.parseFloat(scanner.nextLine()));
            System.out.println("Enter the isAvailable");
            cricketer.setAvailable(Boolean.parseBoolean(scanner.nextLine()));
            cricketerDatabase[Cricketer.getNumberOfCricketers()-1] = cricketer;
        }
    }
    public int checkDatabaseCapacity(){
        return cricketerDatabase.length - Cricketer.getNumberOfCricketers();
    }

    public  void updateCricketer(){

    }
}

