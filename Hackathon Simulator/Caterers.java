public class Caterers
{
  public String name;
  public int rate;
  public float rating;

  Caterers(String name, int rate, float rating)
  {
    this.name = name;
    this.rate = rate;
    this.rating = rating;
  }


  public static final Caterers RISING_SUN_PIZZA()
  {
    String name = "Rising Sun Pizza";
    int rate = 3;
    float rating = 8.0f;

    return new Caterers(name, rate, rating);
  }

  public static final Caterers BURGER_BANDITS()
  {
    String name = "Burger Bandits";
    int rate = 5;
    float rating = 7.5f;

    return new Caterers(name, rate, rating);
  }

  public static final Caterers SCHOOL_CAFETERIA()
  {
    String name = "School Cafeteria";
    int rate = 2;
    float rating = 6.0f;

    return new Caterers(name, rate, rating);
  }

}
