package Bit_and_Math;

public class LC191_Hamming_Weight {
    public int hammingWeight1(int n) {
        int count = 0;
        int mask = 1;
        while (n != 0) {
            if ((n & mask) != 0) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public int hammingWeight3(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask << i) != 0) {
                count++;
            }
        }
        return count;
    }
}
