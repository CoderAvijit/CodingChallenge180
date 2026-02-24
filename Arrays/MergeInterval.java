package CodingChallenge180.Arrays;

import java.util.*;

public class MergeInterval {
    public static int[][] mergeIntervals(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        List<int[]> mergedInterval = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int si = intervals[0][0];
        int ei = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (ei >= intervals[i][0]) {
                ei = Math.max(ei, intervals[i][1]);
            } else {
                mergedInterval.add(new int[] { si, ei });
                si = intervals[i][0];
                ei = intervals[i][1];
            }
        }

        mergedInterval.add(new int[] { si, ei });

        return mergedInterval.toArray(new int[mergedInterval.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                { 1, 2 },
                { 1, 4 },
                { 5, 6 },
                { 6, 7 },
                { 8, 9 }
        };
        int[][] ans = mergeIntervals(intervals);
        for (int[] ansArr : ans) {
            System.out.println("pair1: " + ansArr[0] + ", pair2: " + ansArr[1]);
        }

    }

}
