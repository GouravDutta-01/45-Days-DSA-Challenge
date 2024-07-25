// Question Link : https://leetcode.com/problems/combination-sum-ii/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, target, candidates, new ArrayList<>(), ans);
        return ans;    
    }
    public void solve(int ind, int target, int[] candidates, List<Integer> path, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=ind; i<candidates.length; i++){
            if(i>ind && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > target){
                break;
            }
            path.add(candidates[i]);
            solve(i+1, target-candidates[i], candidates, path, ans);
            path.remove(path.size()-1);
        }
    }
}