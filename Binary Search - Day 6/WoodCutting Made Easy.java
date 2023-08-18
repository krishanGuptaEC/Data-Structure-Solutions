public class Solution {
    public boolean check(int[] A,int B,int C){
        int n = A.length;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum+=Math.max(A[i]-C,0);
        }
        return sum>=B;
    }
    
    public int solve(int[] A, int B) {
        int n = A.length;
        int low = 0;
        int high = A[0];
        for(int i=0;i<n;i++){
            high = Math.max(high,A[i]);
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(A,B,mid)){
                low = mid+1;
            }else{
                high = high-1;
            }
        }
        return low-1;
    }
}
