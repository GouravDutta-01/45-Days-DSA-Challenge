// Question Link : https://leetcode.com/problems/cheapest-flights-within-k-stops/
class Solution {
    class Pair{
        int node;
        int cost;
        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            adjList.get(u).add(new Pair(v, cost));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;
        int stops = 0;
        while(!q.isEmpty() && stops <= k){
            int count = q.size();
            while(count-- > 0){
                Pair curr = q.poll();
                for(Pair p : adjList.get(curr.node)){
                    if(price[p.node] > curr.cost + p.cost){
                        price[p.node] = curr.cost + p.cost;
                        q.add(new Pair(p.node, price[p.node]));
                    }
                }
            }
            stops++;
        }
        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];    
    }
}