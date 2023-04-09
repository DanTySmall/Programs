// Daniel Small
// Feb 2023
// Not for class just for fun
// Sorts numbers and shows sorting graphically

// MAIN OBJECTIVE: HOW DO YOU WANT TO HAVE BARS DISPLAYED???

import java.util.Arrays;

public class Sort
{
  public static int[] entryArray;
  public static int[] sortedArray;
  public static int numOfEntries;

  public static void storeArray(String[] nums)
  {
    numOfEntries = nums.length;

    // Inputs Received from the command line
    System.out.println(Arrays.toString(nums));
    int[] input = new int[numOfEntries];

    // Converts strings in args to integers
    for(int entryNum = 0; entryNum < numOfEntries; entryNum++)
      input[entryNum] = Integer.parseInt(nums[entryNum]);


    entryArray = input;
    //System.out.println(Arrays.toString(entryArray));

  }

  public static void main(String [] args)
  {
    // Tell the user if numbers were received from the command line
    if (args.length < 1)
    {
      // TODO: Learning how to recieve imputs is not the objective of this program
      // do it at a later time

       System.out.println("No inputs were recieved from the command line.");
       System.out.println("Try again with numbers in the command line");
    }else
    {

      //numOfEntries = args.length;
      storeArray(args);
      //int[] nums = Arrays.copyof(input,10);


      // To Become a Method
      // Graphically Represents Arrays

      // Find the maximum value in the array
      float maximum = entryArray[0];
      for (float num : entryArray)
      {
        if (num > maximum)
            maximum = num;
      }


      int[] blocks = new int[numOfEntries];
      //System.out.println("Num of Entries" + numOfEntries);

      //Assign each value there number of blocks
      for(int entryNum = 0; entryNum < numOfEntries; entryNum++)
      {
          float percent = (float)((entryArray[entryNum]*100.0) / maximum);
          //System.out.print(percent);
          int numBlocks = (int)(percent/20.0);
          blocks[entryNum] = numBlocks;
      }
      //System.out.println(Arrays.toString(blocks));

      //System.out.println(Arrays.toString(blocks));

      //!!!WARNING!!! MAGIC NUMBER
      for (int chartLevel = 5; chartLevel >= 1; chartLevel--)// Fills chart from top to bottom
      {
        System.out.print("|");
        for(int position = 0; position < blocks.length; position++)// Fills chart from left to right
        {
            // Fills position with space or a square
            if (blocks[position] >= chartLevel)
            {
              System.out.print('\u2588');
            }else
            {
              System.out.print(' ');
            }
            System.out.print("|");
        }
        System.out.print("\n");
      }

    }
  }




}
