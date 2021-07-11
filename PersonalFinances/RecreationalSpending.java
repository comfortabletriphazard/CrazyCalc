package PersonalFinances;

/**
 * Created by kevin McCaughan on 04/12/2020
 * UPDATE PROGRAM COMMENTS ABOUT PROGRAM HERE
 **/
public class RecreationalSpending extends budgetAmount
{
    private double tv, music, wifi, clothes, socialActivities, totalRecreational;

    protected RecreationalSpending() {

    }//Default constructor

    protected RecreationalSpending(String kName, double kCurentSavings, double kSalaryAfterTax)
    {
        super(kName, kCurentSavings, kSalaryAfterTax);
    }//Alternative constructor which calls the super constructor

    protected RecreationalSpending(String kName, double kCurrentSavings,double kSalaryAfterTax,double cTv, double cMusic, double cWifi, double cClothes, double cSocialActivities)
    {
        super(kName, kCurrentSavings, kSalaryAfterTax);
        tv =cTv;
        music = cMusic;
        wifi = cWifi;
        clothes = cClothes;
        socialActivities = cSocialActivities;
    }//Alternative constructor which initialises all values

    public double getTv()
    {
        return tv;
    }   public void setTv(double tv)
{
    this.tv = tv;
}   public double getMusic()
{
    return music;
}   public void setMusic(double music)
{
    this.music = music;
}   public double getWifi()
{
    return wifi;
}   public void setWifi(double wifi)
{
    this.wifi = wifi;
}   public double getClothes()
{
    return clothes;
}   public void setClothes(double clothes)
{
    this.clothes = clothes;
}   public double getSocialActivities()
{
    return socialActivities;
}   public void setSocialActivities(double socialActivities)
{
    this.socialActivities = socialActivities;
}   protected static void welcomeRecreational()
{
    System.out.println("Recreational Spending Calculator");
}//welcome method

    protected double totalRecreational()
    {
        totalRecreational = getTv()+getMusic()+getWifi()+getClothes()+getSocialActivities();
        return totalRecreational;
    }   protected double weeklyBudget2()
{
    return (super.getCurrentSavings() +getSalaryAfterTax())/52;
}}//class