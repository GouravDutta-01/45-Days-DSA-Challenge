// Question Link : https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans = new ArrayList<>();
        dfs(0, 0, "", ans, mat);
        return ans;
    }
    public void dfs(int i, int j, String path, ArrayList<String> ans, int[][] mat){
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || mat[i][j] == 0){
            return;
        }
        if(i == mat.length-1 && j == mat[0].length-1){
            ans.add(path);
            return;
        }
        mat[i][j] = 0;
        dfs(i+1, j, path+"D", ans, mat);
        dfs(i, j+1, path+"R", ans, mat);
        dfs(i-1, j, path+"U", ans, mat);
        dfs(i, j-1, path+"L", ans, mat);
        mat[i][j] = 1;
    }
}