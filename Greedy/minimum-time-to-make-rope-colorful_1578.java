// Question Link : https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int prevMax = 0;
        int time = 0;
        for(int i=0; i<colors.length(); i++){
            if(i>0 && colors.charAt(i) != colors.charAt(i-1)){
                prevMax = 0;
            }
            int curr = neededTime[i];
            time += Math.min(prevMax, curr);
            prevMax = Math.max(prevMax, curr);
        }
        return time;    
    }
}