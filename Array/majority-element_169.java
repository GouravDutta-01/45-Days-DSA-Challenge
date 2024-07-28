// Question Link : https://leetcode.com/problems/majority-element/
class Solution {
    public int majorityElement(int[] nums) { //Moore's Voting Algorithm
        int element = nums[0];
        int count = 0;
        for(int val : nums){
            if(count == 0){
                count++;
                element = val;
            }
            else if(val == element){
                count++;
            }
            else{
                count--;
            }
        }
        // int checkCount = 0; // As in question given there always exists a majority element, so no need to verify
        // for(int val : checkCount){
        //     if(val == element){
        //         checkCount++;
        //     }
        // }
        return element;    
    }
}