// Question Link : https://leetcode.com/problems/find-the-most-competitive-subsequence/
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i] && stack.size() + nums.length - i > k){
                stack.pop();
            }
            if(stack.size() < k){
                stack.push(i);
            }
        }
        int[] ans = new int[k];
        int ind = k-1;
        while(!stack.isEmpty()){
            ans[ind--] = nums[stack.pop()];
        }
        return ans;    
    }
}