// Question Link : https://leetcode.com/problems/k-closest-points-to-origin/
class Solution {
    class Pair{
        int key;
        int ind;
        public Pair(int key, int ind){
            this.key = key;
            this.ind = ind;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.key - b.key);
        int i = 0;
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            pq.add(new Pair(x*x + y*y, i++));
        }
        int[][] ans = new int[k][2];
        i = 0;
        while(k-- > 0){
            Pair curr = pq.poll();
            int ind = curr.ind;
            int x = points[ind][0];
            int y = points[ind][1];
            ans[i++] = new int[]{x, y};
        }
        return ans;    
    }
}