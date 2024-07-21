// Question Link : https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(dfs(i, -1, vis, adj) == true){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int neighbor : adj.get(node)){
            if(neighbor == parent){
                continue;
            }
            if(vis[neighbor] == true){
                return true;
            }
            if(dfs(neighbor, node, vis, adj) == true){
                return true;
            }
        }
        return false;
    }
}