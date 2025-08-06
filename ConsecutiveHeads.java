import java.util.*;
/*Calculate the number of flips of a coin required to reach a consecutive number of heads.
 * This was a lab for class that I changed around a bit to play with just because I thought
 * it was fun seeing what sorts of numbers I can get up to, and calculating how long it would take
 * to calculate certain numbers of heads.
 */
class GVCoin {
   private boolean isHeads;
   private long flips, heads;
   private Random r;

   public GVCoin() {
     r = new Random();
     heads = 0;
     flips = 0;
     isHeads = true;     
   }

   public void flip() {
     isHeads = r.nextBoolean();
     flips++;
     if(isHeads){
         heads++;
     }
   }
    
   public boolean isHeads() {
     return isHeads;
   }    

   public String toString() {
     String str;
     str = "Flips: " + flips + " Heads: " + heads + " isHeads: " + isHeads;
     return str;
   }    
   
   public long numFlips() {
     return flips;
   }
    
   public long numHeads() {
     return heads;
   }
    

   public long numTails() {
     return flips - heads;
   }

   public void setToHeads(boolean h) {
     isHeads = h; 
   }

   public GVCoin(int seed) { 
     this();
     r = new Random(seed);
   }    
}

public class ConsecutiveHeads {
   
   public static long consecutiveHeads(GVCoin c, int goal) {
      int consecutiveHeads = 0;
      while (consecutiveHeads < goal) {
         c.flip();
         if (c.isHeads()) {
            consecutiveHeads++;
         } else {consecutiveHeads = 0;}
      }
      return c.numFlips();
   }
   
   public static void main(String[] args) {
      GVCoin c = new GVCoin();
      Scanner scnr = new Scanner(System.in);
      System.out.print("Enter a number of consecutive heads to keep flipping until reached: ");
      int numHeads = scnr.nextInt();
      long startTime = System.nanoTime();
      long flips = consecutiveHeads(c, numHeads);
      long endTime = System.nanoTime();
      double timeInSeconds = (endTime - startTime) / 1_000_000_000.0;
      System.out.println("Total number of flips for " + numHeads + " consecutive heads: " + flips);
      System.out.println("Time taken: " + timeInSeconds + " seconds");
      System.out.println("Flips per second: " + (flips / timeInSeconds));
      scnr.close();
   }
}