// Question Link : https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[n];
        return solve(0, graph, m, color);
    }
    public boolean solve(int node, boolean[][]  graph, int m, int[] color){
        if(node == graph.length){
            return true;
        }
        for(int i=1; i<=m; i++){
            if(isPossible(node, i, color, graph)){
                color[node] = i;
                if(solve(node+1, graph, m, color)){
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }
    public boolean isPossible(int node, int i, int[] color, boolean[][] graph){
        for(int j=0; j<graph.length; j++){
            if(j != node && graph[node][j] && color[j] == i){
                return false;
            }
        }
        return true;
    }   
}