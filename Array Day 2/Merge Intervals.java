public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> A, Interval newInterval) {
        // Add the newInterval to the ArrayList of Intervals
        A.add(newInterval);
        
        // Sort the ArrayList of Intervals based on their start values
        Collections.sort(A, new Comparator<Interval>() {
            @Override
            public int compare(Interval l1, Interval l2) {
                return l1.start - l2.start;
            }
        });
        
        int n = A.size();
        Interval prev = new Interval(A.get(0).start, A.get(0).end);
        ArrayList<Interval> ans = new ArrayList<>();
        
        // Iterate through the sorted Intervals to merge overlapping or adjacent intervals
        for (int i = 1; i < n; i++) {
            Interval cur = A.get(i);
            if (prev.end > cur.start && prev.end > cur.end) {
                // If the current Interval is completely overlapped, skip it
                continue;
            } else if (prev.end > cur.start && prev.end <= cur.end) {
                // If there's an overlap and the end of the current Interval extends the previous Interval, update the end of the previous Interval
                prev.end = cur.end;
            } else {
                // If there's no overlap or adjacent Interval, add the previous Interval to the answer and update prev
                ans.add(prev);
                prev = cur;
            }
        }
        
        // Add the last Interval to the answer
        ans.add(prev);
        
        return ans;
    }
}
