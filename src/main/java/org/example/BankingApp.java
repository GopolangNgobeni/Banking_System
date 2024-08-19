package org.example;
import java.util.Scanner;

public class BankingApp {
    int choice;

    Scanner option = new Scanner(System.in);
    public void displayManu() {
        System.out.println("Welcome to Online-banking ");

        System.out.println("\n\n1. Log-in");
        System.out.println("2. Create Account ");
        System.out.println("3. Exit ");

    }
    public void selectOption(){
        choice = option.nextInt();
        CreateAccount open = new CreateAccount();

        switch (choice){
            case 1:
                System.out.println("Welcome back");
            case 2:
                open.openAccount();
                break;
            case 3:
                System.out.println("Goodbye...");
                System.exit(0);
                break;

        }


    }


}