package MankCalculator;

import java.time.LocalTime;
import java.util.Scanner;

/**
 * Created by Michael on 12/12/2020
 * Video Game class to record data post-calculation and save to file for time-stamped record
 */

public class GameReview {

    static Scanner keyboard = new Scanner(System.in);

    String title;
    String platform;
    String quickReview;
    double userReview;
    double cost;
    double dlcCost;
    double hoursPlayed;

    public void VideoGame(String title, String platform, double userReview, String quickReview, double cost, double dlcCost, double hoursPlayed) {
        this.title = title;
        this.platform = platform;
        this.userReview = userReview;
        this.quickReview = quickReview;
        this.cost = cost;
        this.dlcCost = dlcCost;
        this.hoursPlayed = hoursPlayed;
    }

    public static void qualitativeData() {
        String title;
        String platform;
        double userReview;
        String quickReview;
        double cost;
        double dlcCost;
        double hoursPlayed;

        System.out.println("We know the value of a game can change over the test of time.");
        System.out.println("Please enter the details of the games you wish to record the value for using the questionnaire.\n");

        System.out.println("\nPlease enter the name of the game: \n");
        title = keyboard.nextLine();
        System.out.println("The name of the game you played is: " + title);

        System.out.println("\nPlease enter the console/platform that you played the game on: \n");
        platform = keyboard.nextLine();
        System.out.println("The console/platform you played the game on is: " + platform);

        System.out.println("\nPlease enter a rating out of 10 for the game: \n");
        userReview = keyboard.nextDouble();
        System.out.println("You rated the game " + userReview);

        System.out.println("\nPlease enter a quick review of what you thought of the game: \n");
        quickReview = keyboard.nextLine();
        System.out.println("Thank you for your review. This is what you entered: " + quickReview);

        System.out.println("\nPlease enter what the game cost you: \n");
        cost = keyboard.nextDouble();
        System.out.println("The game cost £" + cost + " on " + LocalTime.now().toString());

        System.out.println("\nPlease enter any DLC costs here: \n");
        dlcCost = keyboard.nextDouble();
        System.out.println("DLC cost is: " + dlcCost);

        System.out.println("\nHow many hours have you played the game to date?\n");
        hoursPlayed = keyboard.nextDouble();
        System.out.println("Hours played is " + hoursPlayed);


    }

    public static void gameReviewRunner() {

        qualitativeData();

    }
}

