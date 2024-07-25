// Question Link : https://leetcode.com/problems/combinations/
//Method 1
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, new ArrayList<>(), ans, n, k);
        return ans;    
    }
    public void solve(int ind, List<Integer> path, List<List<Integer>> ans, int n, int k){
        if(k == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(ind > n){
            return;
        }
        path.add(ind);
        solve(ind+1, path, ans, n, k-1);//take
        path.remove(path.size()-1);
        solve(ind+1, path, ans, n, k);//notTake
    }
}

//Method 2
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, new ArrayList<>(), ans, n, k);
        return ans;    
    }
    public void solve(int ind, List<Integer> path, List<List<Integer>> ans, int n, int k){
        if(k == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=ind; i<=n; i++){
            path.add(i);
            solve(i+1, path, ans, n, k-1);
            path.remove(path.size()-1);
        }
    }
}