package Greedy;

import java.util.*;

public class LC1386_Cinema_Seat_Allocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        if (reservedSeats == null || reservedSeats.length == 0 || reservedSeats[0] == null || reservedSeats[0].length == 0) return 0;
        int res = 0;
        Map<Integer, List<Integer>> rowOfRes = new HashMap<>();
        for (int[] a : reservedSeats) {
            if (!rowOfRes.containsKey(a[0])) {
                rowOfRes.put(a[0], new ArrayList<>(Arrays.asList(a[1])));
            } else {
                rowOfRes.get(a[0]).add(a[1]);
            }
        }

        res = (n - rowOfRes.size()) * 2; // empty rows without reservation
        for (List<Integer> list : rowOfRes.values()) { //check avaliability for each row
            boolean flag = true; //if the middle seats are avaliable
            if (!list.contains(2) &&
                    !list.contains(3) &&
                    !list.contains(4) &&
                    !list.contains(5)
            ) {
                res++;
                flag = false;
            }
            if (!list.contains(6) &&
                    !list.contains(7) &&
                    !list.contains(8) &&
                    !list.contains(9)
            ) {
                res++;
                flag = false;
            }
            if (flag) {
                if (!list.contains(4) &&
                        !list.contains(5) &&
                        !list.contains(6) &&
                        !list.contains(7)
                ) {
                    res++;
                }
            }
        }

        return res;
    }
}
