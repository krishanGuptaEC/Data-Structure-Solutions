public class Solution {
    public int pow(int a, int y, int d) {
        // Handle the case where base 'a' is 0 (anything raised to the power of 0 is 1)
        if (a == 0) {
            return 0;
        }
        
        // Initialize the result variable as 1, and 'x' as 'a'
        long res = 1;
        long x = a;
        
        // Perform the exponentiation using bitwise operations and modulo 'd'
        while (y > 0) {
            // Check if the least significant bit of 'y' is 1 (odd power)
            if ((y & 1) == 1) {
                res = (res * x) % d; // Multiply 'res' by 'x' and take modulo 'd'
            }
            y = y >> 1; // Right shift 'y' to process the next bit
            x = (x * x) % d; // Square 'x' and take modulo 'd'
        }
        
        // Take the final result modulo 'd' and handle cases where result might be negative
        return (int) ((d + res) % d);
    }
}
