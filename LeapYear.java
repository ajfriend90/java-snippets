import java.util.Scanner;
/*Enter a year and find out if it's a leap year. This is a common problem in many
 * class labs, so I figured it might be useful to save the logic that calculates
 * leap years to look back on.
 */
public class LeapYear {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int inputYear;
      boolean isLeapYear;
      
      System.out.print("Enter a year (yyyy): ");
      inputYear = scnr.nextInt();
      isLeapYear = (inputYear % 4 == 0 && (inputYear % 100 != 0 || inputYear % 400 == 0));

      if (isLeapYear) {
         System.out.printf("%d - leap year\n", inputYear);
      } else {
         System.out.printf("%d - not a leap year\n", inputYear);   
      }
      scnr.close();
    }
}