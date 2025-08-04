import java.util.Scanner; 

public class MatrixMultiplication {
   public static void main(String[] args) {
	  // Multiplies a 1xN matrix A by a NxN matrix B to output a 1xN matrix C 
     // Define variables and gather input from user
      Scanner scnr = new Scanner(System.in);
      System.out.print("Enter the matrix size N (A is 1xN, B is NxN): ");
      int n = scnr.nextInt();
      int[] matrixA = new int[n];        // Matrix A
      int[][] matrixB = new int[n][n];   // Matrix B 
      int[] matrixC = new int[n];        // Matrix C
      
      // Populate Matrix A
      System.out.print("Enter " + n + " integers for Matrix A (1 x " + n + "): ");
      for (int i = 0; i < n; i++) {
         matrixA[i] = scnr.nextInt();   
      }
      
      // Populate Matrix B
      System.out.println("Enter " + (n * n) + " integers for Matrix B (" + n + " x " + n + "), row by row:");
      for (int i = 0; i < n; i++) {
         System.out.print("Row " + (i + 1) + ": ");
         for (int j = 0; j < n; j++) {
            matrixB[i][j] = scnr.nextInt();   
         }   
      }
      
      // Populate Matrix C
      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            matrixC[i] += matrixA[j]*matrixB[j][i];
         }
      }
      
      // Print Matrix C
      for (int i = 0; i < n; i++) {
         System.out.printf("%d ", matrixC[i]);   
      }
      System.out.println();
      scnr.close();
   }
}