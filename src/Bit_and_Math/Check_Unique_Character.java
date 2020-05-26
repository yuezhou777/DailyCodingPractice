package Bit_and_Math;

public class Check_Unique_Character {
    public boolean checkUnique(char[] chars) {
        if (chars == null || chars.length == 0) return false;
        int[] bitmap = new int[8]; //8 * 32 = 256
        for (char c : chars) {
            int row = c / 32;
            int col = c % 32;
            if ((bitmap[row] & (1 << col)) != 0) {
                return false;
            }
            bitmap[row] |= (1 << col);
        }
        return true;
    }
}
