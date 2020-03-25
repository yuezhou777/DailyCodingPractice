package Greedy;

import java.util.Arrays;

public class LC253_Meeting_Rooms_II {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        //sort
        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int curEnd = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] < end[curEnd]) {
                rooms++;
            } else {
                curEnd++;
            }
        }

        return rooms;
    }
}
