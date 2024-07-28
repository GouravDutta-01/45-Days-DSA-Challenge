// Question Link : https://leetcode.com/problems/subarray-sums-divisible-by-k/
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        for(int val : nums){
            prefixSum += val;
            int rem = prefixSum%k;
            if(rem < 0){
                rem += k;
            }
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;    
    }
}