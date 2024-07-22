// Question Link : https://leetcode.com/problems/move-zeroes/
class Solution {
    public void moveZeroes(int[] nums) {
        int ind = 0;
        for(int val : nums){
            if(val != 0){
                nums[ind++] = val;
            }
        }
        while(ind < nums.length){
            nums[ind++] = 0;
        }   
    }
}