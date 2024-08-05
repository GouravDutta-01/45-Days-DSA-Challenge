// Question Link : https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1
class Solution {
    public int findPair(int n, int x, int[] arr) {
        Arrays.sort(arr);
        int l = 0;
        int r = 1;
        while(r < n){
            if(arr[r]-arr[l] == x){
                return 1;
            }
            else if(arr[r]-arr[l] > x){
                l++;
                if(l == r){
                    r++;
                }
            }
            else{
                r++;
            }
        }
        return -1;
    }
}
