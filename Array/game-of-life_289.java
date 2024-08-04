// Question Link : https://leetcode.com/problems/game-of-life/
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] temp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                temp[i][j] = board[i][j];
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int countLive = solve(i, j, temp);
                if(board[i][j] == 1){
                    if(countLive < 2){
                        board[i][j] = 0;
                    }
                    else if(countLive == 2 || countLive == 3){
                        board[i][j] = 1;
                    }
                    else if(countLive > 3){
                        board[i][j] = 0;
                    }
                }
                else{
                    if(countLive == 3){
                        board[i][j] = 1;
                    }
                }
            }
        }   
    }
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};
    public int solve(int i, int j, int[][] temp){
        int m = temp.length;
        int n = temp[0].length;
        int countLive = 0;
        for(int[] direction : directions){
            int r = i+direction[0];
            int c = j+direction[1];
            if(r<0 || c<0 || r>=m || c>=n){
                continue;
            }
            if(temp[r][c] == 1){
                countLive++;
            }
        }
        return countLive;
    }
}