package Bit_and_Math;

public class LC231_Power_of_Two {
    //S1: 自顶向下
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    //S2: 自底向上
    public boolean isPowerOfTwo3(int n) {
        long num = 1;
        while (num < n) {
            //num *= 2; overflow
            num <<= 1;
        }
        return num == n;
    }

    //Bit
    public boolean isPowerOfTwo4(int n) {
        return n >= 1 && (n & (n - 1)) == 0;
    }

    //Hamming Weight
    public boolean isPowerOfTwo5(int n) {
        if (n <= 0) return false;
        int numOneBit = 0;
        while (n != 0) {
            if ((n & 1) != 0) numOneBit++;
            n >>>= 1;
        }
        return numOneBit == 1;
    }
}
