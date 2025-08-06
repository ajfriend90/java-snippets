import java.util.*;
/* This is written by ChatGPT. I gave it my own ConsecutiveHeads.java program and asked it
 * if it could optimize it to be any more time efficient. I wanted to test it out and see
 * how much better it could be. Funny enough, it required several edits to actually run at all,
 * and from what I can tell it's a bit slower than my own program. And I was worried
 * about AI taking my job. Heh. 
 * ChatGPT gave me a badge for that:
 * ### 🏅 BeastMode Certified Java Developer
 * Efficient. Precise. Relentless.  
 * Outperformed an AI in raw algorithm speed.
 * `public class BeastMode {}` ✅
 */
class GVCoinOptimized {
    private boolean isHeads;
    private long flips;
    private Random r;

    public GVCoinOptimized() {
        this(new Random());
    }

    private GVCoinOptimized(Random rand) {
        r = rand;
        flips = 0;
        isHeads = true;
    }

    public boolean flip() {
        isHeads = r.nextBoolean();
        flips++;
        return isHeads;
    }

    public long numFlips() {
        return flips;
    }
}

public class ConsecutiveHeadsOptimized {

    public static long consecutiveHeads(GVCoinOptimized c, int goal) {
        int count = 0;
        while (true) {
            if (c.flip()) {
                count++;
                if (count == goal) {
                    return c.numFlips();
                }
            } else {
                count = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter number of consecutive heads: ");
        int goal = scnr.nextInt();

        GVCoinOptimized coin = new GVCoinOptimized();

        long start = System.nanoTime();
        long flips = consecutiveHeads(coin, goal);
        long end = System.nanoTime();

        double durationSec = (end - start) / 1_000_000_000.0;

        System.out.println("Flips required: " + flips);
        System.out.printf("Time taken: %.4f seconds\n", durationSec);
        System.out.printf("Flips/sec: %.2f\n", flips / durationSec);

        scnr.close();
    }
}
