// Question Link : https://leetcode.com/problems/number-of-islands/
class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;   
    }
    public void dfs(int i, int j, boolean[][] vis, char[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] == true || grid[i][j] == '0'){
            return;
        }
        vis[i][j] = true;
        for(int[] dir : directions){
            int r = i+dir[0];
            int c = j+dir[1];
            dfs(r, c, vis, grid);
        }
    }
}