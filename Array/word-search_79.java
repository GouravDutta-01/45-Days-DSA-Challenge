// Question Link : https://leetcode.com/problems/word-search/
class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(solve(0, i, j, board, word)){
                        return true;
                    }
                }
            }
        }
        return false;    
    }
    public boolean solve(int ind, int i, int j, char[][] board, String word){
        if(ind == word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] == '*' || board[i][j] != word.charAt(ind)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        for(int[] direction : directions){
            int new_r = i+direction[0];
            int new_c = j+direction[1];
            if(solve(ind+1, new_r, new_c, board, word)){
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
}