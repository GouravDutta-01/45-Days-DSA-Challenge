// Question Link : https://leetcode.com/problems/subsets-ii/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;    
    }
    public void solve(int ind, int[] nums, List<Integer> path, List<List<Integer>> ans){
        ans.add(new ArrayList<>(path));
        for(int i=ind; i<nums.length; i++){
            if(i>ind && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            solve(i+1, nums, path, ans);
            path.remove(path.size()-1);
        }
    }

}