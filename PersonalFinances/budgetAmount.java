package PersonalFinances;

import java.text.DecimalFormat;

/**
 * Created by kevin McCaughan on 02/12/2020
 * UPDATE PROGRAM COMMENTS ABOUT PROGRAM HERE
 **/
public class budgetAmount {
    private String name;
    private double currentSavings, salaryAfterTax, budgetTotal;

    protected budgetAmount() {
    }//This is the Default constructor

    protected budgetAmount(String kName,double kCurrentSavings, double kSalaryAfterTax)

    {
        name = kName;
        currentSavings = kCurrentSavings;
        salaryAfterTax = kSalaryAfterTax;
    }//Alternative constructor

    public String getName()

    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentSavings() {
        return currentSavings;
    }

    public void setCurrentSavings(double currentSavings) {
        this.currentSavings = currentSavings;
    }

    public double getSalaryAfterTax() {
        return salaryAfterTax;
    }

    public void setSalaryAfterTax(double salaryAfterTax) {
        this.salaryAfterTax = salaryAfterTax;
    }

    protected static void welcomeMessage() {
        System.out.println("\nWelcome to the MANK Personal Budget Calculator");
    }//Method to print out welcome message

    public String toString()

    {
        DecimalFormat df = new DecimalFormat("0.00");
        return ("\n" + getName() + " you currently have: \n £" + df.format(getCurrentSavings()) + " in Savings\n An income of £"
                + df.format(getSalaryAfterTax()) + " after tax\n Meaning you have a budget of £" + (getCurrentSavings() + getSalaryAfterTax()));
    }//toString to display  object info
}//class
