// Question Link : https://leetcode.com/problems/gas-station/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int currTank = 0;
        int start = 0;
        for(int i=0; i<gas.length; i++){
            gasSum += gas[i];
            costSum += cost[i];
            currTank += gas[i]-cost[i];
            if(currTank < 0){
                currTank = 0;
                start = i+1;
            }
        }
        return (gasSum >= costSum) ? start : -1;    
    }
}