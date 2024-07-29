// Question Link : https://www.geeksforgeeks.org/problems/bipartite-graph/1
class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for(int i=0; i<V; i++){
            if(color[i] == -1){
                if(dfs(i, color, 1, adj) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int curr, int[] color, int currColor, ArrayList<ArrayList<Integer>>adj){
        color[curr] = currColor;
        for(int neighbor : adj.get(curr)){
            if(color[neighbor] == currColor){
                return false;
            }
            if(color[neighbor] == -1){
                color[neighbor] = 1-currColor;
                if(dfs(neighbor, color, color[neighbor], adj) == false){
                    return false;
                }
            }
        }
        return true;
    }
}