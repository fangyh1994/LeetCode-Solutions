/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0){
            return new ArrayList<Interval>();
        }
        Comparator<Interval> comparator = new Comparator<Interval> () {
            @Override
            public int compare (Interval i1, Interval i2){
                if (i1.start < i2.start){
                    return -1;
                } else if (i1.start > i2.start) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Collections.sort(intervals,comparator);
        List <Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 0; i < intervals.size() - 1; i++){
            if (end < intervals.get(i+1).start){
                result.add(new Interval(start, end));
                start = intervals.get(i+1).start;
                end = intervals.get(i+1).end;
            } else {
                end = Math.max(end, intervals.get(i+1).end);
                //result.add(new Interval(start,end));
            }
        }
        result.add (new Interval(start,end));
        return result;
    }
}