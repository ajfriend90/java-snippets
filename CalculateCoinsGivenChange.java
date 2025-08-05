import java.util.Scanner; 
/*Calculates the fewest of each type of coin to make up a total change in cents. 
 * Another problem that comes up often in class labs that I figured I'd save for
 * future reference.
 */
public class CalculateCoinsGivenChange {

   public static void exactChange(int userTotal, int[] coinVals) {
      int quarters = userTotal / 25;
      int dimes = (userTotal - (quarters*25)) / 10;
      int nickels = (userTotal - (quarters*25) - (dimes*10)) / 5;
      int pennies = (userTotal - (quarters*25) - (dimes*10) - (nickels*5));
      coinVals[3] = quarters;
      coinVals[2] = dimes;
      coinVals[1] = nickels;
      coinVals[0] = pennies;
      return;
   }
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.print("Enter a total change in cents: ");
      int userTotal = scnr.nextInt();
      if (userTotal == 0) {
         System.out.println("no change");
         scnr.close();
         return;
      }
      int[] coinVals = new int[4];
      exactChange(userTotal, coinVals);
      String[][] coinNames = {
         {"penny", "pennies"},
         {"nickel", "nickels"},
         {"dime", "dimes"},
         {"quarter", "quarters"},
      };
      for (int i = 0; i < 4; i++) {
         if (coinVals[i] == 0) {continue;}
         else if (coinVals[i] == 1) {System.out.println(coinVals[i] + " " + coinNames[i][0]);}
         else {System.out.println(coinVals[i] + " " + coinNames[i][1]);}
      }
      scnr.close();
   }
}