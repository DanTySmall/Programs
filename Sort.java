// Daniel Small
// Feb 2023
// Not for class just for fun
// Sorts numbers and shows sorting graphically

// MAIN OBJECTIVE: HOW DO YOU WANT TO HAVE BARS DISPLAYED???
// TODO: Have print Array recieve an array instead of looking at fields
// TODO: Learn how to recieve inputs from user at a later date

import java.util.Arrays;

public class Sort
{
  public static int[] entryArray;
  public static int[] sortedArray;
  public static int numOfEntries;

  public static void storeArray(String[] nums)
  {
    // Inputs Received from the command line
    numOfEntries = nums.length;
    System.out.println(Arrays.toString(nums));
    int[] input = new int[numOfEntries];

    // Converts strings in args to integers
    for(int entryNum = 0; entryNum < numOfEntries; entryNum++)
      input[entryNum] = Integer.parseInt(nums[entryNum]);

    // Stores Array into entryArray
    entryArray = input;

  }

  public static void printArray()
  {
    // To Become a Method
    // Graphically Represents Arrays

    // Find the maximum value in the array
    float maximum = entryArray[0];
    for (float num : entryArray)
    {
      if (num > maximum)
          maximum = num;
    }

    // Finds the height of each bar in bar graph
    int[] blocks = new int[numOfEntries];
    for(int entryNum = 0; entryNum < numOfEntries; entryNum++)
    {

        float percent = (float)((entryArray[entryNum]*100.0) / maximum);
        int numBlocks = (int)(percent/20.0);
        blocks[entryNum] = numBlocks;

    }

    // TODO: When you make the printArray method make the graph scalable at any height
    //!!!WARNING!!! MAGIC NUMBER
    // Fills chart from top to bottom
    for (int chartLevel = 5; chartLevel >= 1; chartLevel--)
    {

      System.out.print("|");

      // Fills chart from left to right
      for(int position = 0; position < blocks.length; position++)
      {

          // Fills position with space or a square
          if (blocks[position] >= chartLevel)
          {
            System.out.print('\u2588');
          }
          else
          {
            System.out.print(' ');
          }
          System.out.print("|");

      }
      System.out.print("\n");
    }

  }

  public static void main(String [] args)
  {
    // Tell the user if numbers were received from the command line
    if (args.length < 1)
    {

      // This would be the point where you recieve input from the user.
      System.out.println("No inputs were recieved from the command line.");
      System.out.println("Try again with numbers in the command line");

    }
    else
    {

      storeArray(args);
      printArray();

    }
  }




}
