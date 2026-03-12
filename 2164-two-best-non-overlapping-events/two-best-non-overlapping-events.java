import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;

        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int val = events[i][2];
            int next = binarySearch(events, events[i][1]);

            if (next != -1) {
                val += suffixMax[next];
            }

            ans = Math.max(ans, val);
        }

        return ans;
    }

    private int binarySearch(int[][] events, int endTime) {
        int left = 0, right = events.length - 1;
        int res = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (events[mid][0] > endTime) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }
}