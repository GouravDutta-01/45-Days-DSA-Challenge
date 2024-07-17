// Question Link : https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
class Solution // Brute Force
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	int[] iKnow = new int[n];
    	int[] knowsMe = new int[n];
    	for(int i=0; i<M.length; i++){
    	    for(int j=0; j<M[0].length; j++){
    	        if(M[i][j] == 1){
    	            iKnow[i]++;
    	            knowsMe[j]++;
    	        }
    	    }
    	}
    	for(int i=0; i<n; i++){
    	    if(iKnow[i] == 0 && knowsMe[i] == n-1){
    	        return i;
    	    }
    	}
    	return -1;
    }
}