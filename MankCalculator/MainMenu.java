package MankCalculator;

import java.util.Scanner;

import static MankCalculator.CarExpenditure.carExpenditureRunner;
import static MankCalculator.CarFinancials.carLoanRunner;
import static MankCalculator.ChristmasBudget.ChristmasBudgetRun;
import static MankCalculator.VideoGameTools.runGameTools;

/**
 * Created by Michael Laverty on 12/12/2020
 * Main menu program
 */
public class MainMenu {
    static Scanner keyboard = new Scanner(System.in);

    public static void printMainMenu() {


        System.out.println("\n\nWelcome to the MNK application menu.");
        System.out.println("Please select an option from the below menu by entering the number");
        System.out.println("1\t Car Expenditure Calculator");
        System.out.println("2\t Video Game Tools");
        System.out.println("3\t Car Loan Calculator");
        System.out.println("4\t Christmas Budget Calculator");
        System.out.println("5\t Exit");

        System.out.println("Please enter your choice:");
    }

    public static void runMainMenu() {
        printMainMenu();
        String choice = keyboard.nextLine();//Get user's choice
        while (true) {
            switch (choice) {
                case "1":
                    carExpenditureRunner();
                    break;
                case "2":
                    runGameTools();
                    break;
                case "3":
                    carLoanRunner();
                    break;
                case"4":
                    ChristmasBudgetRun();
                case "5":
                    System.out.println("Exiting Program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a number from 1 to 3");
                    runMainMenu();
            }//switch
        }//while
    }//runMainMenu
}//class
