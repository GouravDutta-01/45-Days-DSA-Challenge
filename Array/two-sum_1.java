// Question Link : https://leetcode.com/problems/two-sum/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int ind = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                ans[ind++] = i;
                ans[ind] = map.get(target-nums[i]);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;    
    }
}