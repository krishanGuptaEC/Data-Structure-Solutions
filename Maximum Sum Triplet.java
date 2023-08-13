// Given an array A containing N integers.

// You need to find the maximum sum of triplet ( Ai + Aj + Ak ) such that 0 <= i < j < k < N and Ai < Aj < Ak.

// If no such triplet exists return 0.







public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        int[] maxima = new int[n];
        for(int i=n-1;i>=0;i--){
            if(i==n-1) maxima[i] = A[i];
            else maxima[i] = Math.max(maxima[i+1],A[i]);
        }
        TreeSet<Integer> set = new TreeSet();
        set.add(-1);
        set.add(A[0]);
        int ans = 0;
        for(int i=1;i<n-1;i++){
            if(set.lower(A[i])!=-1 && maxima[i+1]>A[i]) ans = Math.max(set.lower(A[i])+A[i]+maxima[i+1],ans);
            set.add(A[i]);
        }
        return ans;
    }
}