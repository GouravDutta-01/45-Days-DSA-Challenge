// Question Link : https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
class Solution { //Brute Force
    public int minMoves2(int[] nums) {
        long minMoves = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            long currMoves = 0;
            for(int j=0; j<nums.length; j++){
                currMoves += Math.abs(nums[i]-nums[j]);
            }
            minMoves = Math.min(minMoves, currMoves);
        }
        return (int)minMoves;   
    }
}