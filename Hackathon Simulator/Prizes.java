public class Prizes
{

  public String name;
  public String firstPlace;
  public String secondPlace;
  public String thirdPlace;
  public int cost;


  Prizes(String name, String firstPlace, String secondPlace, String thirdPlace, int cost)
  {
    this.name = name;
    this.firstPlace = firstPlace;
    this.secondPlace = secondPlace;
    this.thirdPlace = thirdPlace;
    this.cost = cost;

  }

  public static final Prizes CASH()
  {

    String name = "Cash";
    String firstPlace = "500 dollars";
    String secondPlace = "250 dollars";
    String thirdPlace = "100 dollars";
    int cost = 850;

    return new Prizes(name, firstPlace,secondPlace,thirdPlace,cost);
  }

  public static final Prizes NICE_COMPUTER()
  {
    String name = "Nice Computers";
    String firstPlace = "A Razor Laptop";
    String secondPlace = "A Thinkpad";
    String thirdPlace = "A Chromebook";
    int cost = 1200;

    return new Prizes(name,firstPlace,secondPlace,thirdPlace,cost);
  }

  public static final Prizes PENCILS()
  {

    String name = "Pencils";
    String firstPlace = "Zero Gravity Pens";
    String secondPlace = "Sparkly Pencils";
    String thirdPlace = "Yellow No.2 Pencils";
    int cost = 40;

    return new Prizes(name,firstPlace,secondPlace,thirdPlace,cost);
  }



}
