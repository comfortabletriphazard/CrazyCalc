package MankCalculator;

import java.text.DecimalFormat;
import java.util.Scanner;

import static MankCalculator.MainMenu.runMainMenu;

/**
 * Created by Michael Laverty on 12/12/2020
 * Program to calculate the value of video games per hour based on cost and time played
 */
public class VideoGameCalculator extends GameReview {

    static Scanner keyboard = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("£0.00");

    static String gameChoice;
    static double gameCost;
    static double hoursPlayed;
    static double dlcCost;
    static double totalCost;
    static double totalValue;


    public static void gameChoice() {
        System.out.println("Welcome to the MANK Video Game Value Calculator!\n");
        System.out.println("This calculator will allow you to explore the time/cost value for your games collection.");
        System.out.println("\t\t\t\t   ___");
        System.out.println("\t\t\t\t  |   |");
        System.out.println("\t\t\t\t|       |");;
        System.out.println("\t\t ______  \t\t ______");
        System.out.println("\t   \\ \t\t []  []   \t\t/");
        System.out.println("\t\t \\\t\t []\t []\t \t /");
        System.out.println("\t\t\t\\\t\t\t   /");
        System.out.println("\t  \t\t/\t    _\t\t\\");
        System.out.println("\t\t  /  \t  /   \\  \t  \\");
        System.out.println("      \t/\t  / \t\t  \\ \t \\");
        System.out.println("\t  L   _/\t\t\t\t \\_  _|");
        System.out.println("**************************************");
        System.out.println("\t\t\t\tLETS-A GO!");
        System.out.println("**************************************");


        System.out.println("What game would you like to calculate the value of?:\n");
        gameChoice = keyboard.nextLine();
    }//game choice method

    public static void platformOfGame() {
        int platformOfGame;
        System.out.println("\nWhat platform is this game on?: \n");
        System.out.println("\nPlease choose a number (1, 2 or 3) from the following: \n");
        System.out.println("\n1. Nintendo Switch \n2. Microsoft Xbox \n3. Sony PlayStation\n_____________________\n");
        platformOfGame = keyboard.nextInt();

        switch(platformOfGame) {
            case 1:
                System.out.println("\nNintendo Switch\n");
                System.out.println("Top Nintendo Switch titles, especially those developed by Nintendo, usually hold their value or appreciate over time.");
                System.out.println("Nintendo Switch games usually retail for approximately £45, even years after release.");
                System.out.println("TIP: You can check how much time you play games on your Nintendo Switch profile.");

                break;
            case 2:
                System.out.println("Microsoft Xbox");
                System.out.println("Top Xbox titles can start off retailing at £59.99, but can depreciate to less than £10 over time, depending on the title.");
                System.out.println("TIP: You can check how much time you play games on your PlayStation profile.");
                break;
            case 3:
                System.out.println("Sony PlayStation");
                System.out.println("Top PlayStation titles can start off retailing at £59.99, but can depreciate to less than £10 over time, depending on the title.");
                System.out.println("TIP: You can check how much time you play games on your Xbox profile.");
                break;
            default:
                System.out.println("Sorry, you have entered an invalid choice.\nPlease try again using the number 1, 2 or 3. \nThank you for your consideration.\n");
                platformOfGame();
        }//switch

    }//platform of game method

    public static double gameCost() {
        System.out.println("\nHow much did " + gameChoice + " cost you?\n");
        return gameCost = keyboard.nextDouble();
    }//game cost method

    public static double dlcCost() {
        System.out.println("\nHow much have you spent on DLC, or any additional in-game items, in " + gameChoice + "?\n");
        System.out.println("(If you have not purchased DLC or any additional content, please simply enter 0)");
        return dlcCost = keyboard.nextDouble();
    }//DLC cost method

    public static double hoursPlayed() {
        System.out.println("\nHow many hours have you played " + gameChoice + "?\n");
        return hoursPlayed = keyboard.nextDouble();
    }//hours played method

    public static void totalValue() {
        totalCost = gameCost + dlcCost;
        totalValue = totalCost/hoursPlayed;
    }//total value method

    public static void gameValueResult() {
        System.out.println("\nThe total value of " + gameChoice + " is calculated as " + df.format(totalValue) + " per hour!\n");
        System.out.println("Remember. Not every game is the created the same.");
        System.out.println("Whether a game is short or long, the most important this is that you enjoy the time you spent with them. :)");
    }//game value result

//    public static void calculateAnother() {
//        System.out.println("\nWould you like to calculate the value of another game? (Y or N)");
//        answer = keyboard.nextLine();
//
//        if (answer.equalsIgnoreCase("n")){
//            System.out.println("\nThank you for using the MANK Video Game Value Calculator.\nPlease consider us for use again in the future.");
//            System.exit(0);
//        }
//
//        else if(answer.equalsIgnoreCase("y")){
//            videoGameRunner();
//        }
//    }//calculate another game

    public static void videoGameRunner() {

        gameChoice();
        platformOfGame();
        gameCost();
        dlcCost();
        hoursPlayed();
        totalValue();
        gameValueResult();
        runMainMenu();
        //calculateAnother(); //Would not work correctly

    }//main
}//class