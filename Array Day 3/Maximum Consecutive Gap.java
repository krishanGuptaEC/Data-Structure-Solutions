public class Solution {
    public int maximumGap(final int[] A) {
        if (A.length < 2) return 0;
        if (A.length == 2) return Math.abs(A[0] - A[1]);
        
        int n = A.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        // Find the minimum and maximum values in the array
        for (int i = 0; i < n; i++) {
            min = Math.min(A[i], min);
            max = Math.max(A[i], max);
        }
        
        // Initialize arrays to store minimum and maximum values in each bucket
        int[] minBkt = new int[n - 1];
        int[] maxBkt = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            minBkt[i] = Integer.MAX_VALUE;
            maxBkt[i] = Integer.MIN_VALUE;
        }
        
        // Calculate the approximate width of each bucket
        double delta = (double) (max - min) / (n - 1);
        
        // Distribute elements into buckets and find minimum and maximum values in each bucket
        for (int i = 0; i < n; i++) {
            if (A[i] == min || A[i] == max) continue;
            int idx = (int) ((A[i] - min) / delta);
            minBkt[idx] = Math.min(A[i], minBkt[idx]);
            maxBkt[idx] = Math.max(A[i], maxBkt[idx]);
        }
        
        int ans = 0;
        int prev = min;
        
        // Calculate the maximum gap between buckets
        for (int i = 0; i < n - 1; i++) {
            if (minBkt[i] == Integer.MAX_VALUE && maxBkt[i] == Integer.MIN_VALUE) continue;
            ans = Math.max(ans, minBkt[i] - prev);
            prev = maxBkt[i];
        }
        
        // Calculate the maximum gap between the last bucket's maximum value and overall maximum value
        ans = Math.max(ans, max - prev);
        
        return ans;
    }
}
