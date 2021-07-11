package MankCalculator;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static MankCalculator.MainMenu.runMainMenu;

/**
 * Created by Michael Laverty on 28/11/2020
 * Car Financial information and Personal Loan information Gathering *
 **/
public class CarFinancials {

    static Scanner keyboard = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("£0.00");
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();

    static String customerName;
    static String carManufacturer;
    static String carModel;
    static double carCost = 0;
    static double deposit = 0;
    static double loanAmount = 0;
    static double interestRate = 0;
    static double tradeInValue;
    static double numOfMonths;
    static double totalLoan;
    static double monthlyCost;
    static final double MAX_LOAN_LENGTH =60;
    static final double MIN_LOAN_LENGTH =12;

    public static void carPicture()
    {
        System.out.println("                           _..-------++._'                                  ");
        System.out.println("                      _. -  / |      _||  \\'--._       ------------------                    ");
        System.out.println("             ___ _.-- '`._/__|_____/_||___\\   `--'                        ");
        System.out.println("         .- _____    |          \'    _____      /     --------------                    ");
        System.out.println("     __'_j /, ---.\"  |        =o |   /,---.\"    |_                        ");
        System.out.println("    [__] ==// .-. \"==============/==// .-. \"=[__]     ---------                    ");
        System.out.println("      `-.____ `-' /|_____________/____ `-' / | _. ...... MANK Car Loans.......   ");
        System.out.println("             `---'                    `---'                 ");
    }

    public static void customerName() {

        System.out.println("Welcome to the MANK Car loan Calculator!\n");
        System.out.println("\nFirst of all, please share your name with us: \n");
        customerName = keyboard.nextLine();
    }
    public static void carDetails() {

        System.out.println("Who is the manufacturer of your car? (This could be Toyota, Renault etc.)\n");
        carManufacturer = keyboard.nextLine().toUpperCase();

        System.out.println("\nWhat model is your car?\n");
        carModel = keyboard.nextLine().toUpperCase();

        System.out.println("\nThank you for letting us know that you drive a " + carManufacturer + " " + carModel + ", " + customerName + ".");

    }


    public static void getCarCost() {
        System.out.println("What is the cost of the car?");
        carCost = keyboard.nextDouble();
        if (carCost == 0) {
            System.out.println("Please enter the value of the car: ");
        }
    }

    public static void getDeposit() {
        System.out.println("Please enter deposit amount below. If you do not wish to put down a deposit, please enter 0.");
        deposit = keyboard.nextDouble();
        System.out.println("The deposit amount of " + df.format(deposit) + " will be deducted from the value of the car you wish to purchase.");
    }

    public static void getTradeInValue() {
        System.out.println("If you have a car to trade in please enter the value of your trade in below.");
        tradeInValue = keyboard.nextDouble();
        System.out.println("The trade in value of " + df.format(tradeInValue) + " will be take of the car value.");
    }
    public static void numOfMonths(){
        System.out.println("Please enter the length of the loan in months (between 12 and 60): ");
        numOfMonths = keyboard.nextDouble();
        if (numOfMonths < MIN_LOAN_LENGTH){
            System.out.println("The loan length is below the minimum for a loan. Please enter months between 12 and 60");
        } else if(numOfMonths > MAX_LOAN_LENGTH){
            System.out.println("The loan length is to large, please enter number of months between 12 and 60");
        }
    }
    public static void loanAmount(){
        loanAmount = carCost - (deposit + tradeInValue);
        if (loanAmount<0){
            System.out.println("You are unable to get a loan for this vehicle. You can afford this car outright.");
        } else {
            System.out.println("The initial value of the loan without interest would be: " + df.format(loanAmount));
        }
    }

    public static void interestRate(){
        System.out.println("Please enter the interest rate available to you: ");
        interestRate = keyboard.nextDouble();
         if(interestRate==0){
             System.out.println("Please enter a value between 0 and 100");
         }
         else if(interestRate>100){
             System.out.println("This percentage is too high.");
         }
         interestRate = interestRate / 100;
        }
        public static void calculateTotalLoan(){
        totalLoan = loanAmount + (loanAmount * interestRate);
        System.out.println("The total loan amount is: " + df.format(totalLoan));
        }

        public static void monthlyCost(){
        monthlyCost = totalLoan / numOfMonths;
        System.out.println("Montly cost of your loan would be: " + df.format(monthlyCost));
        }

        public static void loanBreakDown(){
            System.out.println("\n" + customerName +", thank you for your patience and taking the car loan calculator.");
            System.out.println("\nHere's a summary from the information your entered for the car you require a loan for:\n");
            System.out.println("*********************************************");
            System.out.println(customerName.toUpperCase() + " - CAR LOAN BREAKDOWN");
            System.out.println(dtf.format(now));
            System.out.println("*********************************************\n");
            System.out.println("CAR\t " + carManufacturer + " " + carModel);
            System.out.println("___________________________________________________________\n");
            System.out.println("CAR VALUE\t " + df.format(carCost));
            System.out.println("TOTAL LOAN AMOUNT\t " + df.format(loanAmount));
            System.out.println("INTEREST RATE OF LOAN\t " + df.format(interestRate));
            System.out.println("EXPECTED MONTHLY PAYMENT\t " + df.format(monthlyCost));

        }

public static void carLoanRunner() {
            carPicture();
            customerName();
            carDetails();
            getCarCost();
            getDeposit();
            getTradeInValue();
            numOfMonths();
            loanAmount();
            interestRate();
            calculateTotalLoan();
            loanBreakDown();
            monthlyCost();
            runMainMenu();
        }
    }
