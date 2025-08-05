import java.math.BigInteger;
/*
 * Implementation of Fibonacci number calculation using
 * Matrix Exponentiation (O(log n) time complexity).
 *
 * This is a well-known algorithm used to compute the nth
 * Fibonacci number efficiently, based on raising the
 * transformation matrix [[1,1],[1,0]] to the (n-1)th power.
 *
 * Author: Unknown / Public domain
 * Source: Algorithm is widely documented (e.g., CLRS, Wikipedia)
 * Saved for educational and experimental purposes.
 */

public class NthFibonacci {

    public static BigInteger fibonacci(int n) {
        if (n < 0) return BigInteger.valueOf(-1);
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        BigInteger[][] result = {
            {BigInteger.ONE, BigInteger.ZERO},
            {BigInteger.ZERO, BigInteger.ONE}
        };

        BigInteger[][] fibMatrix = {
            {BigInteger.ONE, BigInteger.ONE},
            {BigInteger.ONE, BigInteger.ZERO}
        };

        power(fibMatrix, n - 1, result);

        return result[0][0];
    }

    private static void power(BigInteger[][] base, int exp, BigInteger[][] result) {
        while (exp > 0) {
            if ((exp & 1) == 1) {
                multiply(result, base);
            }
            multiply(base, base);
            exp >>= 1;
        }
    }

    private static void multiply(BigInteger[][] a, BigInteger[][] b) {
        BigInteger x = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0]));
        BigInteger y = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]));
        BigInteger z = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0]));
        BigInteger w = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]));

        a[0][0] = x;
        a[0][1] = y;
        a[1][0] = z;
        a[1][1] = w;
    }

    public static void main(String[] args) {
        int n = 100000000;
        BigInteger fib = fibonacci(n);
        System.out.println("fibonacci(" + n + ") =\n" + fib);
        System.out.println("Length: " + fib.toString().length() + " digits");
    }
}
