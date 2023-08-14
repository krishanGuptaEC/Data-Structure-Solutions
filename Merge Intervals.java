// Question Link :- https://www.interviewbit.com/problems/merge-intervals/

// Solution: Just add new instance in intervals and then use same as merge intervals.

// Step 1 : Add a new intervel to intervels and sort the list.
// Step 2 : Check if the given intervals are overlapping.
// Step 3:- Merge overlapping instances.



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> A, Interval newInterval) {
        A.add(newInterval);
        Collections.sort(A, new Comparator<Interval>(){
            @Override
            public int compare(Interval l1,Interval l2){
                return l1.start-l2.start;
            }
        });
        int n = A.size();
        Interval prev = new Interval(A.get(0).start,A.get(0).end);
        ArrayList<Interval> ans = new ArrayList<>();
        for(int i=1;i<n;i++){
            Interval cur = A.get(i);
            if(prev.end>cur.start && prev.end>cur.end){
                continue;
            }else if(prev.end>cur.start && prev.end<=cur.end){
                prev.end = cur.end;
            }
            else {
                ans.add(prev);
                prev = cur;
            }
        }
        ans.add(prev);
        return ans;

    }
}
