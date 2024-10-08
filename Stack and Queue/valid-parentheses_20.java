// Question Link : https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty() && ((c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '['))){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();   
    }
}