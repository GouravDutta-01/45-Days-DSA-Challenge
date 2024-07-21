// Question Link : https://leetcode.com/problems/flood-fill/
class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        if(startColor != color){
            dfs(sr, sc, image, color, startColor);
        }
        return image;    
    }
    public void dfs(int i, int j, int[][] image, int color, int startColor){
        if(i<0 || j<0 || i>=image.length || j>=image[0].length || image[i][j] != startColor){
            return;
        }
        image[i][j] = color;
        for(int[] dir : directions){
            int newRow = i+dir[0];
            int newCol = j+dir[1];
            dfs(newRow, newCol, image, color, startColor);
        }
    }
}