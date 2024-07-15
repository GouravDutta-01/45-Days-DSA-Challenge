// Question Link : https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        dfs(0, vis, ans, adj);
        return ans;
    }
    public void dfs(int node, boolean[] vis, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        ans.add(node);
        for(int neighbor : adj.get(node)){
            if(!vis[neighbor]){
                dfs(neighbor, vis, ans, adj);
            }
        }
    }
}