// Question Link : https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length+1;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        HashSet<Integer> vis = new HashSet<>();
        for(int[] val : adjacentPairs){
            int u = val[0];
            int v = val[1];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] nums = new int[n];
        int ind = 0;
        for(int node : adjList.keySet()){
            if(adjList.get(node).size() == 1){
                q.offer(node);
                vis.add(node);
                break;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            nums[ind++] = curr;
            for(int neighbor : adjList.get(curr)){
                if(!vis.contains(neighbor)){
                    q.add(neighbor);
                    vis.add(neighbor);
                }
            }
        }
        return nums;    
    }
}