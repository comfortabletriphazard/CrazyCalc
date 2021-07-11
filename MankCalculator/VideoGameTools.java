package MankCalculator;

import java.util.Scanner;

import static MankCalculator.GameReview.gameReviewRunner;
import static MankCalculator.MainMenu.runMainMenu;
import static MankCalculator.VideoGameCalculator.videoGameRunner;

/**
 * Created by Michael on 12/12/2020
 */
public class VideoGameTools {

    static Scanner keyboard = new Scanner(System.in);


    public static void gameTools() {

        System.out.println("Welcome to Video Game tools!");
        System.out.println("1\t Video Game Value calculator");
        System.out.println("2\t Game Review time stamper");
        System.out.println("0\t Return to main menu");

    }

    public static void runGameTools() {

        gameTools();
        String userChoice = keyboard.nextLine();
        while (true) {
            switch (userChoice) {
                case "1":
                    videoGameRunner();
                    break;
                case "2":
                    gameReviewRunner();
                    break;
                case "0":
                    runMainMenu();
                    break;
                default:
                    System.out.println("Please try again with a selection of 1, 2 or 0.");
                    gameTools();
                    break;
            }
        }

    }

}
