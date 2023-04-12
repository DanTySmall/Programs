// Daniel Small
// Feb 2023
// Not for class just for fun
// Sorts numbers and shows sorting graphically

// MAIN OBJECTIVE: Clean up and deal with negative numbers
// ONE DAY: Learn how to recieve inputs from user at a later date
// TODO: What happens if user inputs non numbers?

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
    //System.out.println(Arrays.toString(nums));
    int[] input = new int[numOfEntries];

    // Converts strings in args to integers
    for(int entryNum = 0; entryNum < numOfEntries; entryNum++)
      input[entryNum] = Integer.parseInt(nums[entryNum]);

    // Stores Array into entryArray
    entryArray = input;
    sortedArray = entryArray.clone();

  }

  public static void printArray()
  {

    // Graphically Represents Arrays
    // Find the maximum value in the array
    float maximum = sortedArray[0];
    for (float num : sortedArray)
    {
      if (num > maximum)
          maximum = num;
    }

    // Finds the height of each bar in bar graph
    int height = 10;
    int[] blocks = new int[numOfEntries];
    for(int entryNum = 0; entryNum < numOfEntries; entryNum++)
    {
        if(sortedArray[entryNum] == 0)
        {
          blocks[entryNum] = 0;
        }
        else if (sortedArray[entryNum] > 0 && (sortedArray[entryNum] < (maximum/height)))
        {
          blocks[entryNum] = 1;
        }
        else
        {
           blocks[entryNum] = (int)((sortedArray[entryNum] * height)/maximum);
        }
    }

    // Fills chart from top to bottom
    for (int chartLevel = height; chartLevel >= 1; chartLevel--)
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

  public static void swap(int a, int b)
  {

    int temp = sortedArray[a];
    sortedArray[a] = sortedArray[b];
    sortedArray[b] = temp;

  }

  public static boolean pass()
  {
    //Used in bubble sort

    boolean swapDetect = false;

    for(int position = 1; position < numOfEntries; position++)
    {
      if (sortedArray[position] s< sortedArray[position-1])
      {
        swap(position,position-1);
        swapDetect = true;
      }

    }
    return swapDetect;
  }

  public static void bubbleSort()
  {
    // Completes Bubble Sort
    while (pass())
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
      System.out.println(Arrays.toString(sortedArray));
      printArray();
      System.out.println("=======(Swap)=======");
      bubbleSort();
      printArray();
      System.out.println(Arrays.toString(sortedArray));

    }
  }




}
