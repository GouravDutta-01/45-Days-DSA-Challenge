// Question Link : https://leetcode.com/problems/largest-rectangle-in-histogram/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] pse = prevSmallerElement(heights);
        int[] nse = nextSmallerElement(heights);
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            int currArea = heights[i]*(nse[i]-pse[i]-1);
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;    
    }
    public int[] prevSmallerElement(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        return pse;
    }
    public int[] nextSmallerElement(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i] = nums.length;
            }
            else{
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        return nse;
    } 
}