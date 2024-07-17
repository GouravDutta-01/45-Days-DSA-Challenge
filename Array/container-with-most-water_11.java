// Question Link : https://leetcode.com/problems/container-with-most-water/
class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxWater = 0;
        while(l < r){
            int currWater = Math.min(height[l], height[r])*(r-l);
            maxWater = Math.max(maxWater, currWater);
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxWater;   
    }
}