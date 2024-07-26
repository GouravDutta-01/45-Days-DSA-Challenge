// Question Link : https://leetcode.com/problems/subsets/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;   
    }
    public void solve(int ind, int[] nums, List<Integer> path, List<List<Integer>> ans){
        ans.add(new ArrayList<>(path));
        for(int i=ind; i<nums.length; i++){
            path.add(nums[i]);
            solve(i+1, nums, path, ans);
            path.remove(path.size()-1);
        }
    }
}