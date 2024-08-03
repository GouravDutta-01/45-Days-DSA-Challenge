// Question Link : https://leetcode.com/problems/remove-k-digits/
class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for(char c : num.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek()-'0' > c-'0'){
                stack.pop();
                k--;
            }
            if(!stack.isEmpty() || c != '0'){
                stack.push(c);
            }
        }
        while(!stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }
        if(stack.isEmpty()){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();   
    }
}