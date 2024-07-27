// Question Link : https://www.geeksforgeeks.org/problems/topological-sort/1
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(int val : adj.get(i)){
                indegree[val]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] ans = new int[V];
        int i = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[i++] = curr;
            for(int val : adj.get(curr)){
                indegree[val]--;
                if(indegree[val] == 0){
                    q.add(val);
                }
            }
        }
        return ans;
    }
}