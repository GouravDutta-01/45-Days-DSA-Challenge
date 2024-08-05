// Question Link : https://leetcode.com/problems/find-all-duplicates-in-an-array/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int num = Math.abs(nums[i]);
            int ind = num-1;
            if(nums[ind] < 0){
                ans.add(num);
            }
            else{
                nums[ind] = -nums[ind];
            }
        }
        return ans;    
    }
}