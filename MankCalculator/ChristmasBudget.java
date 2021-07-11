package MankCalculator;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static MankCalculator.MainMenu.runMainMenu;

public class ChristmasBudget {

    static Scanner keyboard = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("£0.00");
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();

    static String userName;
    static double monthlyIncome;
    static double monthlyExpenses;
    static double christmasBudget;
    static double christmasAdditionIncome;
    static double totalChristmasIncome;
    static double averagePresentBudget;
    static int parentsToBuy;
    static int spouseToBuy;
    static String response;
    static int siblingsToBuy;
    static int nephewsOrNieces;
    static int children;
    static int totalFamilyToBuy;
    static double drink;
    static double christmasAdditions;
    static double extraFood;
    static int countFamily = 0;

    private static void TrianglePrint() {
        for (int row = 1; row <= 5; row++) {
            for (int emptySpace = 4; emptySpace >= row; emptySpace--) {
                System.out.print(" ");
            }
            for (int star = 1; star <= (2 * row - 1); star++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }


    public static void userName(){
        System.out.println("Welcome to the MNK Christmas Expenditure Calculator!\n");
        System.out.println("\nFirst of all, please share your first name with us: \n");
        userName = keyboard.nextLine();
    }
    public static void monthlyIncome(){
        System.out.println("Please enter your monthly income: £");
        monthlyIncome = keyboard.nextDouble();
        System.out.println("Your monthly income is: " +df.format(monthlyIncome));
    }

    public static void monthlyExpenses(){
        System.out.println("Please enter your usual monthly expenses: £");
        monthlyExpenses= keyboard.nextDouble();
        System.out.println("Your monthly expenses are roughly: " + df.format(monthlyExpenses));
    }
    public static void savingsForChristmas(){
        System.out.println("Do you have any savings set aside for Christmas: £");
        christmasAdditionIncome = keyboard.nextDouble();
        totalChristmasIncome = christmasAdditionIncome + monthlyIncome;
        System.out.println("Your total income for the Christmas month is " + df.format(totalChristmasIncome));
    }
    public static void estimateChristmasBudget(){
        christmasBudget = totalChristmasIncome - monthlyExpenses;
        System.out.println("Your rough budget for Christmas expenditure is " + df.format(christmasBudget));
    }
    public static void SpouseToBuyFor() {
        System.out.println("Do you have a Partner to buy for: (1 for Yes 0 for No");
        spouseToBuy= keyboard.nextInt();
        if (spouseToBuy == 1) {
            System.out.println("You have a Special person to buy for! ");
            countFamily++;
        } else {
                countFamily=0;
            }
    }
    public static void familyToBuyFor() {
        System.out.println("How many parents to buy for (Press 0 for none): ");
        parentsToBuy = keyboard.nextInt();
        System.out.println("How many siblings do you have to buy for: ");
        siblingsToBuy = keyboard.nextInt();
        System.out.println("How many Nieces or Nephews do you have: ");
        nephewsOrNieces = keyboard.nextInt();
        System.out.println("Do you have any Children: ");
        children = keyboard.nextInt();
    }

    public static void totalFamily(){
        totalFamilyToBuy= countFamily + parentsToBuy + nephewsOrNieces + children + siblingsToBuy + children;
        System.out.println("You have a total of " + totalFamilyToBuy + " family members to buy for.");
    }
    public static void christmasAdditions(){
        System.out.println("How much would you spend on alcohol for Christmas: £ ");
        drink= keyboard.nextDouble();

        System.out.println("How much would you set aside for additional food: £");
        extraFood= keyboard.nextDouble();
        System.out.println("You have these additional costs for food " + df.format(extraFood) + " and drink "+ df.format(drink));

        christmasAdditions= drink + extraFood;
    }
    public static void averageSpendOnFamily(){
        averagePresentBudget= (christmasBudget - christmasAdditions)/totalFamilyToBuy;
        System.out.println("With the information gathered you will have an average budget of " + df.format(averagePresentBudget)
                + " to spend on your family members" );

    }

    public static void ChristmasBudgetBreakDown(){
        System.out.println("\nHere's a summary from the information your entered throughout our journey...ahem!:\n");
        System.out.println("*********************************************");
        System.out.println(userName.toUpperCase() + " - CHRISTMAS EXPENDITURE BREAKDOWN");
        System.out.println(dtf.format(now));
        System.out.println("*********************************************\n");
        System.out.println("___________________________________________________________\n");
        System.out.println("MONTHLY INCOME\t " + df.format(monthlyIncome));
        System.out.println("CHRISTMAS SAVINGS\t\t\t " + df.format(christmasAdditionIncome));
        System.out.println("MONTHLY EXPENSES\t\t\t " + df.format(monthlyExpenses));
        System.out.println("ESTIMATED CHRISTMAS BUDGET\t\t\t " + df.format(christmasBudget));
        System.out.println("TOTAL FAMILY MEMBERS\t\t\t " + totalFamilyToBuy);
        System.out.println("AVERAGE SPEND ON FAMILY\t\t\t " + df.format(averagePresentBudget));
        System.out.println("CHRISTMAS FOOD AND DRINK\t " + df.format(christmasAdditions));
        System.out.println("************************************************************\n");
        System.out.println("Thank you for using the MNK Christmas Expenditure calculator " + userName.toUpperCase());
        System.out.println("We hope this breakdown allows you to make an informed decision about the future of your Christmas expenditure.");
        System.out.println("Have a wonderful Christmas!.");
    }

    public static void ChristmasBudgetRun(){

        TrianglePrint();
        userName();
        monthlyIncome();
        monthlyExpenses();
        savingsForChristmas();
        estimateChristmasBudget();
        SpouseToBuyFor();
        familyToBuyFor();
        totalFamily();
        christmasAdditions();
        averageSpendOnFamily();
        ChristmasBudgetBreakDown();
        runMainMenu();


    }




    }

