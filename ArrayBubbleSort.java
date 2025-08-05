import java.util.Scanner;
/*Sort a given array in descending order using bubble sort algorithm.
 * Came up with this one for a class lab. Looked up bubble sort algorithm
 * pseudocode on Wiki and implemented it into Java. 
 */
public class ArrayBubbleSort {

   public static void sortArray(int[] myArr, int arrSize) {
      int n = arrSize;
      while (true) {
         boolean swapped = false;
         for (int i = 1; i <= n-1; i++) {
            if (myArr[i-1] < myArr[i]) {
               int temp = myArr[i-1];
               myArr[i-1] = myArr[i];
               myArr[i] = temp;
               swapped = true;
            }   
         }
         if (!swapped) {break;}
      }
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.print("Enter the array size: ");
      int arrSize = scnr.nextInt();
      int[] myArr = new int[arrSize];
      System.out.print("Enter " + arrSize + " integers for the array: ");
      for (int i = 0; i < arrSize; i++) {
         myArr[i] = scnr.nextInt();   
      }
      sortArray(myArr, arrSize);
      for (int num : myArr) {
         System.out.printf(num + ",");   
      }
      System.out.println();
      scnr.close();
   }
}