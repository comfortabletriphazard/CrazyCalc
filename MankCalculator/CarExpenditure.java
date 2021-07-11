package MankCalculator;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static MankCalculator.MainMenu.runMainMenu;

/**
 * Created by Michael Laverty on 12/12/2020
 * Program to calculate annual car expenditure and provide percentile information
 */
public class CarExpenditure {

    static Scanner keyboard = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("£0.00");
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();

    static final int NOCARVALUE = 0;
    static final int BIANNUALCARTAXPAYMENT = 2;
    static final int MONTHS = 12;
    static final int NOMOTCOST = 0;
    static final int NOREMOTCOST = 0;
    static final double CARMOTCOST = 30.50;
    static final double CARMOTRETEST = 18.50;
    static String userName;
    static String carManufacturer;
    static String carModel;
    static String carCostAnswer;
    static char carTaxAnswer;
    static char carMotAnswer;
    static char carReMotAnswer;
    static char insuranceAnswer;
    static double parts;
    static double fuel;
    static double misc;
    static double parking;
    static double repairs;
    static double annualCarInsurance;
    static double carCost;
    static double monthlyCarCost;
    static double monthlyMotCost;
    static double monthlyCarInsurance;
    static double carMotCost;
    static double carReMotCost;
    static double monthlyCarTax;
    static double carTaxPayment;
    static double totalCarTax;
    static double totalCarCost;
    static double totalMotCost;
    static double totalFuel;
    static double totalParking;
    static double monthlyRepairs;
    static double monthlyParts;
    static double monthlyMisc;
    static double totalCarInsurance;


    public static void userName() {

        System.out.println("Welcome to the MANK Car Expenditure Calculator!\n");
        System.out.println("\nThis calculator will provide your with an annual breakdown of your car costs.\n");

        System.out.println("\nFirst of all, please share your first name with us: \n");
        userName = keyboard.nextLine();

    }//user name method

    public static void carDetails() {

        System.out.println("Please share with us, who is the manufacturer of your car? (This could be Toyota, Renault etc.)\n");
        carManufacturer = keyboard.nextLine().toUpperCase();

        System.out.println("\nWhat model is your car? (This could be things like Corolla, Clio, Corsa etc.)\n");
        carModel = keyboard.nextLine().toUpperCase();

        System.out.println("\nThank you for letting us know that you drive a " + carManufacturer + " " + carModel + ", " + userName + ".");
        System.out.println("It sounds like a lovely little car!\n");

    }//car details method

    public static void carCost() {

        System.out.println(userName + ", do you pay for your car monthly? (Y or N) \n");
        carCostAnswer = keyboard.nextLine();

        if (carCostAnswer.equalsIgnoreCase("y")) {
            System.out.println("\nHow much are your monthly repayments?:\n");
            carCost = keyboard.nextDouble();
            totalCarCost = carCost * MONTHS;
            monthlyCarCost = carCost;
        } else if (carCostAnswer.equalsIgnoreCase("n")) {
            System.out.println("\nDid you buy your car with an outright payment within the last 12 months? (Y or N)\n");
            carCostAnswer = keyboard.nextLine();
        } else if ((carCostAnswer.equalsIgnoreCase("n"))) {
            System.out.println("Invalid choice! Please press 'Y' or 'N'");
    }
            if (carCostAnswer.equalsIgnoreCase("y")) {
                System.out.println("\nHow much was your outright payment for the car? \n");
                carCostAnswer = keyboard.nextLine();
                System.out.println("(If you would prefer not to include your car cost in the breakdown, please enter 0)");
                carCost = keyboard.nextDouble();
                totalCarCost = carCost;
                monthlyCarCost = carCost / MONTHS;
           // } else if ((carCostAnswer != "y" || carCostAnswer !="n")) {
                System.out.println("\nOk. Thank you " + userName + ". Our calculator will not include your car payment in the final breakdown.\n");
            } else {
            System.out.println("Sorry " + userName + ", you have entered an invalid choice so we will not include your car cost in the breakdown\n");
            carCost = NOCARVALUE;
            totalCarCost = carCost;
            monthlyCarCost = carCost;
        }

    }//car cost method

    public static void carTax() {

        System.out.println("\n" +userName + ", do you pay car tax annually? (Y or N) \n");
        carTaxAnswer = keyboard.next().charAt(0);

        if((carTaxAnswer == 'y') || (carTaxAnswer == 'Y')) {
            System.out.println("\nThank you " + userName + ". Please enter how much you pay annually for car tax: \n");
            carTaxPayment = keyboard.nextDouble();
            totalCarTax = carTaxPayment;
            monthlyCarTax = totalCarTax / MONTHS;
        } else if((carTaxAnswer == 'n') || (carTaxAnswer == 'N')) {
            System.out.println("How much do you pay per month " + userName + "? (If you are lucky and get free car tax, please enter 0)");
            carTaxPayment = keyboard.nextDouble();
            totalCarTax = carTaxPayment * BIANNUALCARTAXPAYMENT;
            monthlyCarTax = carTaxPayment;
        }

    }//car tax method

    public static void mot() {

        System.out.println("\nHas your car been through MOT in the past 12 months? (Y or N) \n");
        carMotAnswer = keyboard.next().charAt(0);

        if ((carMotAnswer == 'y') || (carMotAnswer == 'Y')){
            carMotCost = CARMOTCOST;

            System.out.println("\nHave you had to retest your car for MOT in the past 12 months? (Y or N)\n");
            carReMotAnswer = keyboard.next().charAt(0);

            if ((carReMotAnswer == 'y') || (carReMotAnswer == 'Y')){
                carReMotCost = CARMOTRETEST;
            }else if((carReMotAnswer != 'y') || (carReMotAnswer != 'Y')) {
                carReMotCost = NOREMOTCOST;
            }

        }else if((carMotAnswer == 'n') || (carMotAnswer == 'N')) {
            carMotCost = NOMOTCOST;
        }


        totalMotCost = carMotCost + carReMotCost;
        monthlyMotCost = totalMotCost / MONTHS;

    }//mot method

    public static void fuel() {

        System.out.println("\nHow much do you spend on fuel each month?\n");
        fuel = keyboard.nextDouble();
        totalFuel = fuel * MONTHS;

    }//fuel method

    public static void parking() {

        System.out.println("\nHow much do you spend on parking each month?\n");
        parking = keyboard.nextDouble();
        totalParking = parking * MONTHS;

    }//parking method

    public static void insurance() {

        System.out.println("\nDo you pay your car insurance annually? (Y or N)\n");
        insuranceAnswer = keyboard.next().charAt(0);

        if((insuranceAnswer == 'y') || (insuranceAnswer == 'Y')) {
            System.out.println("\nPlease enter how much you paid for your current annual car insurance policy: \n");
            annualCarInsurance = keyboard.nextDouble();
        }else if(((insuranceAnswer == 'n') || (insuranceAnswer == 'N'))) {
            System.out.println("\nHow much do you pay for your car insurance each month?\n");
            monthlyCarInsurance = keyboard.nextDouble();
            totalCarInsurance = monthlyCarInsurance * MONTHS;
            }

        }//car insurance method

    public static void repairs() {

        System.out.println("\nHow much have you spent on repairs/maintenance over the past 12 months on your car?\n");
        repairs = keyboard.nextDouble();
        monthlyRepairs = repairs / MONTHS;

    }//repairs method

    public static void parts() {

        System.out.println("\nIf you bought any parts for your car to bring to the mechanic in the past year, how much did they amount to?\n");
        parts = keyboard.nextDouble();
       monthlyParts = parts / MONTHS;

    }//parts

    public static void miscellaneous() {

        System.out.println("\nIf you wish to include costs for things like tyre inflation, cleaning materials or even a car air freshener, include the cost here for the year: \n");
        misc = keyboard.nextDouble();
        monthlyMisc = misc / MONTHS;

    }//misc method

    public static void annualBreakdown() {
        System.out.println("\n" + userName +", thank you for your patience and taking the time out of your day to use our calculator.");
        System.out.println("\nHere's a summary from the information your entered throughout our journey...ahem!:\n");
        System.out.println("*********************************************");
        System.out.println(userName.toUpperCase() + " - ANNUAL CAR EXPENDITURE BREAKDOWN");
        System.out.println(dtf.format(now));
        System.out.println("*********************************************\n");
        System.out.println("CAR\t " + carManufacturer + " " + carModel);
        System.out.println("___________________________________________________________\n");
        System.out.println("MONTHLY VEHICLE COST\t " + df.format(monthlyCarCost) + "\t\tYEARLY VEHICLE COST\t\t" + df.format(totalCarCost));
        System.out.println("MONTHLY CAR TAX\t\t\t " + df.format(monthlyCarTax) + "\t\tYEARLY CAR TAX\t\t\t " + df.format(totalCarTax));
        System.out.println("MONTHLY CAR MOT\t\t\t " + df.format(monthlyMotCost) + "\t\tYEARLY CAR MOT \t\t\t" + df.format(totalMotCost));
        System.out.println("MONTHLY FUEL\t\t\t " + df.format(fuel) +"\t\tYEARLY CAR FUEL \t\t" + df.format(totalFuel));
        System.out.println("MONTHLY REPAIRS\t\t\t " + df.format(monthlyRepairs) + "\t\tYEARLY REPAIRS \t\t\t " + df.format(repairs));
        System.out.println("MONTHLY PARTS\t\t\t " + df.format(monthlyParts) + "\t\tYEARLY PARTS \t\t\t " + df.format(parts));
        System.out.println("MONTHLY MISCELLANEOUS\t " + df.format(monthlyMisc) + "\t\tYEARLY MISCELLANEOUS \t " + df.format(misc));
        System.out.println("************************************************************\n");
        System.out.println("Thank you for using the MANK Car Expenditure calculator " + userName.toUpperCase());
        System.out.println("We hope this breakdown allows you to make an informed decision about the future of your vehicle expenditure.");
        System.out.println("Have a delightful day.");

    }//annual breakdown method

    public static void resultDoc() {

        try {
            FileWriter myWriter = new FileWriter("CarExpenditureBreakdown.txt");
            myWriter.write("\r\nFiles in Java might be tricky, but it is fun enough!");
            myWriter.write("\r\n" + userName +", thank you for your patience and taking the time out of your day to use our calculator.");
            myWriter.write("\r\nHere's a summary from the information your entered throughout our journey...ahem!:\n");
            myWriter.write("\r\n*********************************************");
            myWriter.write("\r\n" + userName.toUpperCase() + " - ANNUAL CAR EXPENDITURE BREAKDOWN");
            myWriter.write("\r\n" + dtf.format(now));
            myWriter.write("\r\n*********************************************\n");
            myWriter.write("\r\nnCAR\t " + carManufacturer + " " + carModel);
            myWriter.write("\r\n___________________________________________________________\n");
            myWriter.write("\r\nMONTHLY VEHICLE COST\t " + df.format(monthlyCarCost) + "\t\tYEARLY VEHICLE COST\t\t" + df.format(totalCarCost));
            myWriter.write("\r\nMONTHLY CAR TAX\t\t\t " + df.format(monthlyCarTax) + "\t\tYEARLY CAR TAX\t\t\t " + df.format(totalCarTax));
            myWriter.write("\r\nMONTHLY CAR MOT\t\t\t " + df.format(monthlyMotCost) + "\t\tYEARLY CAR MOT \t\t\t" + df.format(totalMotCost));
            myWriter.write("\r\nMONTHLY FUEL\t\t\t " + df.format(fuel) +"\t\tYEARLY CAR FUEL \t\t" + df.format(totalFuel));
            myWriter.write("\r\nMONTHLY REPAIRS\t\t\t " + df.format(monthlyRepairs) + "\t\tYEARLY REPAIRS \t\t\t " + df.format(repairs));
            myWriter.write("\r\nMONTHLY PARTS\t\t\t " + df.format(monthlyParts) + "\t\tYEARLY PARTS \t\t\t " + df.format(parts));
            myWriter.write("\r\nMONTHLY MISCELLANEOUS\t " + df.format(monthlyMisc) + "\t\tYEARLY MISCELLANEOUS \t " + df.format(misc));
            myWriter.write("\r\n************************************************************\n");
            myWriter.write("\r\nThank you for using the MANK Car Expenditure calculator " + userName.toUpperCase());
            myWriter.write("\r\nWe hope this breakdown allows you to make an informed decision about the future of your vehicle expenditure.");
            myWriter.write("\r\nHave a delightful day.");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void carExpenditureRunner() {
       userName();
       carDetails();
       carCost();
       carTax();
       mot();
       fuel();
       parking();
       insurance();
       repairs();
       parts();
       miscellaneous();
       annualBreakdown();
       resultDoc();
       runMainMenu();

    }//main
}//class
