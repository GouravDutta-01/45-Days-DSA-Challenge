// Question Link : https://leetcode.com/problems/permutations-ii/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        solve(0, nums, new ArrayList<>(), ans, vis);
        return ans;    
    }
    public void solve(int ind, int[] nums, List<Integer> path, List<List<Integer>> ans, boolean[] vis){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(vis[i] == true || (i>0 && nums[i] == nums[i-1] && vis[i-1] == false)){
                continue;
            }
            vis[i] = true;
            path.add(nums[i]);
            solve(i+1, nums, path, ans, vis);
            path.remove(path.size()-1);
            vis[i] = false;
        }
    }
}