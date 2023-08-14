// Link:- https://www.interviewbit.com/problems/perfect-peak-of-array/

// this problem is based on using prefix sum and suffix sum which will give us left side highest till ith position and right side lowest for ith position


public class Solution {
    public int perfectPeak(ArrayList<Integer> A) {
        int n = A.size();
        int[] pref = new int[n];
        int[] suff = new int[n];
        suff[0] = A.get(0);
        pref[n-1] = A.get(n-1);
        for(int i=1;i<n;i++){
            suff[i] = Math.max(suff[i-1],A.get(i));
        }
        for(int i=n-2;i>=0;i--){
            pref[i] = Math.min(pref[i+1],A.get(i));
        }
        
        for(int i=1;i<n-1;i++){
            if(A.get(i)>suff[i-1] && A.get(i)<pref[i+1]) return 1;
        }
        return 0;
    }
}
