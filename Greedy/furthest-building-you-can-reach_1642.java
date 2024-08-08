// Question Link : https://leetcode.com/problems/furthest-building-you-can-reach/
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i;
        for(i=0; i<heights.length-1; i++){
            if(heights[i+1] <= heights[i]){
                continue;
            }
            int diff = heights[i+1]-heights[i];
            if(bricks >= diff){
                bricks -= diff;
                pq.add(diff);
            }
            else if(ladders > 0){
                if(!pq.isEmpty()){
                    int pastMaxBricks = pq.peek();
                    if(pastMaxBricks > diff){
                        bricks += pastMaxBricks;
                        pq.poll();
                        bricks -= diff;
                        pq.add(diff);
                    }
                }
                ladders--;
            }
            else{
                break;
            }
        }
        return i;   
    }
}