/*
Hackathon Simulator
Daniel T. Small

This Program simulates the process of organizing and holding a hackathon

*/

// TODO: ARE THERE OTHER THINGS TO SELECT
// TODO: ADD A DJ/MUSIC OPTION
// TODO: FIGURE OUT PRICES
// TODO: SPONSORSHIPS AT SOME POINT
// TODO AT SOMEPOINT: CONVERT TO GRID FORMAT


import java.util.Scanner;
public class HackathonSimulator{

  public static void clear()
  {
    System.out.print("\033[H\033[2J");
  }

  // This determines whether or not something bad happens during the hackathon
  public static void chance()
  {
    int luck = (int)(Math.random() * 100 + 1);
    // double luck = Math.random()*100;

    System.out.print(luck +" : ");

    if (luck > 25)
    {
      System.out.print("Good Thing\n");
    }
    else
    {
      System.out.print("Bad Thing :(\n");
    }

  }


  public static void main(String[] args)
  {


    int budget = 2000;
    Locations location;
    Caterers cater;

    Prizes prize;
    // System.out.print("\033[H\033[2J");
    //
    // System.out.println("M\"\"MMMMM\"\"MM                   dP                  dP   dP                            MP\"\"\"\"\"\"`MM oo                     dP            dP"     );
    // System.out.println("M  MMMMM  MM                   88                  88   88                            M  mmmmm..M                        88            88"               );
    // System.out.println("M         `M .d8888b. .d8888b. 88  .dP  .d8888b. d8888P 88d888b. .d8888b. 88d888b.    M.      `YM dP 88d8b.d8b. dP    dP 88 .d8888b. d8888P .d8888b. 88d888b." );
    // System.out.println("M  MMMMM  MM 88\'  `88 88\'  `"" 88888\"   88\'  `88   88   88\'  `88 88\'  `88 88\'  `88    MMMMMMM.  M 88 88\'`88\'`88 88    88 88 88\'  `88   88   88\'  `88 88\'  `88" );
    // System.out.println("M  MMMMM  MM 88.  .88 88.  ... 88  `8b. 88.  .88   88   88    88 88.  .88 88    88    M. .MMM\'  M 88 88  88  88 88.  .88 88 88.  .88   88   88.  .88 88 "     );
    // System.out.println("M  MMMMM  MM `88888P8 `88888P\' dP   `YP `88888P8   dP   dP    dP `88888P\' dP    dP    Mb.     .dM dP dP  dP  dP `88888P\' dP `88888P8   dP   `88888P' dP"  );
    // System.out.println("MMMMMMMMMMMM                                                                          MMMMMMMMMMM");

    // Startup
    clear();
    Scanner input = new Scanner(System.in);
    System.out.println("Das ist Hackathon Simulator");
    System.out.println("Press Enter...");
    input.nextLine();

    clear();
    System.out.println("Budget: $" + budget +"\n");

    boolean valid = false;

    // Selecting Location
    do{

      System.out.println("Where do you want the Hackathon to be Located?\n ");
      System.out.println("1- Engineering Building ($" + Locations.ENGINEERING_BUILDING().cost + ")");
      System.out.println("2- School Stadium ($" + Locations.SCHOOL_STADIUM().cost + ")");
      System.out.println("3- Outdoor Classroom ($" + Locations.OUTDOOR_CLASSROOM().cost + ")");

      int enter = input.nextInt();

    switch (enter) {
      case 1:
        location = Locations.ENGINEERING_BUILDING();
        valid = true;
        break;

      case 2:
        location = Locations.SCHOOL_STADIUM();
        valid = true;
        break;

      case 3:
        location = Locations.OUTDOOR_CLASSROOM();
        valid = true;
        break;

      default:
      location = null;
        System.out.println("Input is not valid");
    }
  } while(!valid);

    budget -= location.cost;
    System.out.println();
    clear();

    // Selecting Catering Company
    System.out.println("Budget: $" + budget +"\n");
    do{

      System.out.println("Who do you want to cater the food? \n ");
      System.out.println("1- Rising Sun Pizza ($"+ Caterers.RISING_SUN_PIZZA().rate+" per 10 people) ($" + ((location.capacity * Caterers.RISING_SUN_PIZZA().rate) / 10) +" Total)");
      System.out.println("2- Burger Bandits ($"+ Caterers.BURGER_BANDITS().rate+" per 10 people) ($" + ((location.capacity * Caterers.BURGER_BANDITS().rate) / 10) +" Total)");
      System.out.println("3- School Cafeteria ($"+ Caterers.SCHOOL_CAFETERIA().rate+" per 10 people) ($" + ((location.capacity * Caterers.SCHOOL_CAFETERIA().rate) / 10) +" Total)");
      System.out.println();

      int enter = input.nextInt();

    switch (enter) {
      case 1:
        cater = Caterers.RISING_SUN_PIZZA();
        valid = true;
        break;

      case 2:
        cater = Caterers.BURGER_BANDITS();
        valid = true;
        break;

      case 3:
        cater = Caterers.SCHOOL_CAFETERIA();
        valid = true;
        break;

      default:
        cater = null;
        System.out.println("Input is not valid");
    }
  } while(!valid);

    // Catering Rate feeds 10 people
    budget -= (location.capacity * cater.rate) / 10;

    clear();

    // Selecting Prizes
    System.out.println("Budget: $" + budget +"\n");
    do{

      System.out.println("What Should the top prize be? \n ");
      System.out.println("1- Razor Gaming Computer ");
      System.out.println("2- Cash");
      System.out.println("3- A Really Nice Pencil :)");
      System.out.println();

      int enter = input.nextInt();

    switch (enter) {
      case 1:
        prize = Prizes.NICE_COMPUTER();
        valid = true;
        break;

      case 2:
        prize = Prizes.CASH();
        valid = true;
        break;

      case 3:
        prize = Prizes.PENCILS();
        valid = true;
        break;

      default:
      prize = null;
        System.out.println("Input is not valid");
    }
    } while(!valid);

    budget -= prize.cost;
    System.out.println();
    clear();

    // SOME POINT: Placed so that inputs dont get skipped
    // Fix later
    String x = input.nextLine();

    // Choice Summary
    System.out.println("The location is " + location.name);
    System.out.println("The cater is " + cater.name);
    System.out.println("The prize is " + prize.name);
    System.out.println("Your remaining budget is: $" + budget);
    System.out.println("Press Enter...");
    input.nextLine();

    // SOME POINT: Days could be put in a while loop

    // Day 1

    clear();

    System.out.println("Day 1");
    System.out.println("Kickoff runs smoothly. Students begin brainstorming\n");

    chance();

    System.out.println("Press Enter...");
    input.nextLine();

    // Day 2

    clear();

    System.out.println("Day 2");
    System.out.println("Students are enjoying the food\n");
    chance();

    System.out.println("Press Enter...");
    input.nextLine();


    // Day 3

    clear();

    System.out.println("Day 3");
    System.out.println("Hackathon comes to a nice end.\n");
    chance();

    System.out.println("Press Enter...");
    input.nextLine();


    // Results

    clear();
    System.out.println("First Place: The Electrolytes");
    System.out.println("Second Place: Bumble Buddies");
    System.out.println("Third Place : The Tubes");


  }
}
