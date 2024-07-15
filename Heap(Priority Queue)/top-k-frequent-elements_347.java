// Question Link : https://leetcode.com/problems/top-k-frequent-elements/
class Solution {
    class Pair{
        int val;
        int freq;
        public Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            map.put(val, map.getOrDefault(val, 0) + 1);
            set.add(val);
        }
        for(int val : set){
            pq.add(new Pair(val, map.get(val)));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll().val;
        }
        return ans;     
    }
}