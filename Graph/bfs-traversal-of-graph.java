// Question Link : https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V+1];
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            for(int neighbor : adj.get(curr)){
                if(!vis[neighbor]){
                    q.add(neighbor);
                    vis[neighbor] = true;
                }
            }
        }
        return ans;
    }
}