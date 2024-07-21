// Question Link : https://www.geeksforgeeks.org/problems/multiply-two-linked-lists/1
class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        long mod = 1000000007;
        long num1 = 0;
        long num2 = 0;
        while(first != null){
            num1 = (num1*10 + first.data)%mod;
            first = first.next;
        }
        while(second != null){
            num2 = (num2*10 + second.data)%mod;
            second = second.next;
        }
        return (num1*num2)%mod;
    }
}