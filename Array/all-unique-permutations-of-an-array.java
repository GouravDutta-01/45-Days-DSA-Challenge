// Question Link : https://www.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/0
class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(new ArrayList<>(), new boolean[arr.size()], arr, ans);
        return ans;
    }
    static void solve(ArrayList<Integer> path, boolean[] vis, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans){
        if(path.size() == arr.size()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<arr.size(); i++){
            if(vis[i] == true || (i>0 && arr.get(i) == arr.get(i-1) && vis[i-1] == false)){
                continue;
            }
            vis[i] = true;
            path.add(arr.get(i));
            solve(path, vis, arr, ans);
            vis[i] = false;
            path.remove(path.size()-1);
        }
    }
};