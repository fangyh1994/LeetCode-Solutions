/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
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
    public int minMeetingRooms(Interval[] intervals) {
        Queue <Interval> pq = new PriorityQueue<>(new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return a.end - b.end;
            }
        });
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        for (int i = 0; i < intervals.length; i++){
            if (!pq.isEmpty()){
                if (intervals[i].start < pq.peek().end){
                    pq.add(intervals[i]);
                } else {
                    pq.remove();
                    pq.add(intervals[i]);
                }
            } else {
                pq.add(intervals[i]);
            }
        }
        return pq.size();
    }
}