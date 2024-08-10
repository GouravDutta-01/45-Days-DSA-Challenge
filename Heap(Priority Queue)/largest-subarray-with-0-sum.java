// Question Link : https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
class GfG
{
    int maxLen(int arr[], int n)
    {
        int maxLen = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<n; i++){
            prefixSum += arr[i];
            if(map.containsKey(prefixSum)){
                maxLen = Math.max(maxLen, i-map.get(prefixSum));
            }
            else{
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }
}