// Question Link : https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxScore = 0;
        int l = 0;
        int r = cardPoints.length-1;
        int currScore = 0;
        while(l < k){
            currScore += cardPoints[l++];    
        }
        l--;
        maxScore = currScore;
        while(r >= cardPoints.length-k){
            currScore += (cardPoints[r--] - cardPoints[l--]);
            maxScore = Math.max(maxScore, currScore);
        }
        return maxScore;   
    }
}