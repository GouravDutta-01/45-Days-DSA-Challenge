// Question Link : https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
class Solution {
    static class Pair{
        int node;
        int weight;
        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight-b.weight);
        boolean[] inMST = new boolean[V];
        int sum = 0;
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(inMST[curr.node] == true){
                continue;
            }
            inMST[curr.node] = true;
            sum += curr.weight;
            for(int[] val : adj.get(curr.node)){
                if(!inMST[val[0]]){
                    pq.add(new Pair(val[0], val[1]));
                }
            }
        }
        return sum;
    }
}