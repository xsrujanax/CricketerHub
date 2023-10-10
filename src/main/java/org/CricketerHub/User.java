package org.CricketerHub;

import java.util.Scanner;

public class User {
    private static final String PASSWORD  = "password";
    private int maxWrongAttempts;
    private boolean isLoggedIn = false;

    User(){
        this.maxWrongAttempts = 0;
    }

    public boolean checkPassword(String password){
        return password.equals(PASSWORD);
    }

    public boolean  suspiciousActivity(){
        if(maxWrongAttempts<12)
            return false;
        else {
            System.out.println("\u001B[31mProgram detected suspicious activities and will terminate immediately!\u001B[0m");
            System.exit(0);
            return true;
        }
    }

    public boolean login(){
        Scanner scanner = new Scanner(System.in);
        int wrongAttempts = 0;
        while (!suspiciousActivity())
        {
            if(!isLoggedIn)
            {
                String password = scanner.nextLine();
                if(checkPassword(password)){
                    isLoggedIn = true;
                    break;
                }
                else {
                    if(wrongAttempts < 2){
                        wrongAttempts++;
                        maxWrongAttempts ++;
                        System.out.println("Invalid password," + (3 - wrongAttempts) + " attempts remaining.");
                    }
                    else{
                        System.out.println("\u001B[31mInvalid password, returning to main menu.\u001B[0m\n" );
                        maxWrongAttempts ++;
                        if(!suspiciousActivity())
                            isLoggedIn = false;
                        break;
                    }
                }
            }
        }
        return isLoggedIn;

    }
    public void addCricketer(){
        System.out.println("Add new player");
    }

    public  void updateCricketer(){

    }

    public void findCricketersBy(){

    }

    public  void findAllRounders(){

    }
}

