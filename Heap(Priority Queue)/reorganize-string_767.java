// Question Link : https://leetcode.com/problems/reorganize-string/
class Solution {
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > (s.length()+1)/2){
                return "";
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.add(new int[]{entry.getValue(), entry.getKey()});
        }
        while(pq.size() >= 2){
            int[] p1 = pq.poll();
            int[] p2 = pq.poll();
            sb.append((char)p1[1]);
            sb.append((char)p2[1]);
            p1[0]--;
            p2[0]--;
            if(p1[0] > 0){
                pq.add(new int[]{p1[0], p1[1]});
            }
            if(p2[0] > 0){
                pq.add(new int[]{p2[0], p2[1]});
            }
        }
        if(!pq.isEmpty()){
            int[] p1 = pq.poll();
            sb.append((char)p1[1]);
        }
        return sb.toString();    
    }
}