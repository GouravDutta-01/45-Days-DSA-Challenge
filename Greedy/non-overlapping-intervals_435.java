// Question Link : https://leetcode.com/problems/non-overlapping-intervals/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[1]-b[1]);
        int countMaxMeetings = 1;
        int lastEndTime = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= lastEndTime){
                countMaxMeetings++;
                lastEndTime = intervals[i][1];
            }
        }
        return intervals.length-countMaxMeetings;    
    }
}