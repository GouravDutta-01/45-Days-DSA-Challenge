// Question Link : https://leetcode.com/problems/merge-sorted-array/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sortedArr = new int[m+n];
        int i = 0;
        int j = 0;
        int ind = 0;
        while(i<m && j<n){
            if(nums1[i] < nums2[j]){
                sortedArr[ind++] = nums1[i++];
            }
            else{
                sortedArr[ind++] = nums2[j++];
            }
        }
        while(i<m){
            sortedArr[ind++] = nums1[i++];
        }
        while(j<n){
            sortedArr[ind++] = nums2[j++];
        }
        for(int k=0; k<m+n; k++){
            nums1[k] = sortedArr[k];
        }    
    }
}