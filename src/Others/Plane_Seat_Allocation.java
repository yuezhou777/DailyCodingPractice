package Others;

import java.util.*;

public class Plane_Seat_Allocation { //LC1386
    public int maxNumberOfFamilies(int n, String reservedSeats) {
        if (reservedSeats == null || reservedSeats.length() == 0) return 0;
        int res = 0;
        Map<Integer, List<Character>> rowOfRes = new HashMap<>();
//        for (int[] a : reservedSeats) {
//            if (!rowOfRes.containsKey(a[0])) {
//                rowOfRes.put(a[0], new ArrayList<Character>(Arrays.asList(a[1])));
//            } else {
//                rowOfRes.get(a[0]).add(a[1]);
//            }
//        }

        res = (n - rowOfRes.size()) * 2; // empty rows without reservation
        for (List<Character> list : rowOfRes.values()) { //check avaliability for each row
            boolean flag = true; //if the middle seats are avaliable
            if (!list.contains('B') &&
                    !list.contains('C') &&
                    !list.contains('D') &&
                    !list.contains('E')
            ) {
                res++;
                flag = false;
            }
            if (!list.contains('F') &&
                    !list.contains('G') &&
                    !list.contains('H') &&
                    !list.contains('J')
            ) {
                res++;
                flag = false;
            }
            if (flag) {
                if (!list.contains('D') &&
                        !list.contains('E') &&
                        !list.contains('F') &&
                        !list.contains('G')
                ) {
                    res++;
                }
            }
        }

        return res;
    }
}
