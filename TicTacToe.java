import java.util.Scanner;
public class TicTacToe
{

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";

    // TODO: Deal with incorrect outputs( len > 1, non num)
    // TODO: Place Both X's and O's
    public static char [][] gameBoard = {{' ',' ',' '},
                                         {' ',' ',' '},
                                         {' ',' ',' '}};


    //Prints the GameBoard
    public static void printGameBoard()
    {


      char[][] display = {{' ',' ',' '},
                          {' ',' ',' '},
                          {' ',' ',' '}};

      //The color at each position
      String[][] color = {{ANSI_RESET,ANSI_RESET,ANSI_RESET},
                          {ANSI_RESET,ANSI_RESET,ANSI_RESET},
                          {ANSI_RESET,ANSI_RESET,ANSI_RESET}};

      //Each Row
      for (int row = 0; row < 3; row++)
      {

        //Each Column
        for(int col = 0; col < 3; col++)
        {
          char num = (char)((row * 3 + col + 1 ) + '0');
          if (gameBoard[row][col] == ' ')
          {
            display[row][col] = num ;
          }
          else
          {
            display[row][col] = gameBoard[row][col];
          }

          if (gameBoard[row][col] == 'X')
          {
            color[row][col] = ANSI_RED;
          }
          else if (gameBoard[row][col] == 'O')
          {
            color[row][col] = ANSI_CYAN;
          }


        }


      }

      System.out.println(color[0][0] + display[0][0] + ANSI_RESET + "|" + color[0][1] + display[0][1] + ANSI_RESET + "|" + color[0][2] + display[0][2] + ANSI_RESET);
      System.out.println("-+-+-");
      System.out.println(color[1][0] + display[1][0] + ANSI_RESET + "|" + color[1][1] + display[1][1] + ANSI_RESET + "|" + color[1][2] + display[1][2] + ANSI_RESET);
      System.out.println("-+-+-");
      System.out.println(color[2][0] + display[2][0] + ANSI_RESET + "|" + color[2][1] + display[2][1] + ANSI_RESET + "|" + color[2][2] + display[2][2] + ANSI_RESET);


    }

    public static boolean isFree (int x)
    {
      return (gameBoard[((x-1) /3)][(x-1) % 3] == ' ');
    }

    public static boolean isWin()
    {
      boolean win = false;

      for (int col = 0; col < 3; col++)
      {
          if (gameBoard[0][col] != ' ' && gameBoard[0][col] == gameBoard[1][col] && gameBoard[0][col] == gameBoard[2][col])
          {
            return true;
          }
      }

      for (int row = 0; row < 3; row++)
      {
          if (gameBoard[row][0] != ' ' && gameBoard[row][0] == gameBoard[row][1] && gameBoard[row][0] == gameBoard[row][2])
          {
            return true;
          }
      }

      if(gameBoard[0][0] != ' ' && gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2])
      {
        return true;
      }

      if(gameBoard[0][2] != ' ' && gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0])
      {
        return true;
      }

      return false;
    }

    public static void place(int pos, char c)
    {
      if(isFree(pos))
      {
        int row = ((pos - 1) / 3);
        int col = (pos - 1) % 3;
        gameBoard[row][col] = c;
      }
      else
      {
        System.out.println("That spot has been taken!");
      }


    }

    public static void main(String[] args) {

      Scanner s = new Scanner(System.in);
      char player = 'X';
      while(true)
      {
        System.out.print("\033[H\033[2J");  
        printGameBoard();

        if(isWin())
        {
          System.out.println("Win!");
          break;
        }

        System.out.println(player + "'s Turn\n");
        String i = s.nextLine();
        int num = (int)i.charAt(0) - '0';
        place(num, player);


        if (player == 'X')
        {
          player = 'O';
        }
        else
        {
          player = 'X';
        }
      }

    }

}
