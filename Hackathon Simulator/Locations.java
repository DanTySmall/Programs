public class Locations{

  public String name;
  public int cost;
  public int capacity;

  Locations(String name, int cost, int capacity)
  {
    this.name = name;
    this.cost = cost;
    this.capacity = capacity;
  }

  public static final Locations ENGINEERING_BUILDING()
  {
    String name = "Engineering Building";
    int cost = 500;
    int capacity = 275;

    return new Locations(name, cost, capacity);
  }

  public static final Locations SCHOOL_STADIUM()
  {
    String name = "School Stadium";
    int cost = 700;
    int capacity = 500;

    return new Locations(name, cost, capacity);
  }


  public static final Locations OUTDOOR_CLASSROOM()
  {
    String name = "Outdoor Classroom";
    int cost = 300;
    int capacity = 200;

    return new Locations(name, cost, capacity);
  }








}
