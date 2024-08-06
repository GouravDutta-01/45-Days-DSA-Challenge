// Question Link : https://leetcode.com/problems/task-scheduler/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.add(entry.getValue());
        }
        int intervals = 0;   
        while(!pq.isEmpty()){
            int count = n+1;
            List<Integer> list = new ArrayList<>();
            while(count-- > 0){
                if(!pq.isEmpty()){
                    int freq = pq.poll();
                    freq--; 
                    list.add(freq);
                }
            }
            for(int val : list){
                if(val != 0){
                    pq.add(val);
                }
            }
            if(!pq.isEmpty()){
                intervals += n+1;
            }
            else{
                intervals += list.size();
            }
        }
        return intervals;
    }
}