// Question Link : https://leetcode.com/problems/generate-parentheses/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve("", n, ans);
        return ans;   
    }
    public void solve(String s, int n, List<String> ans){
        if(s.length() == 2*n){
            if(isValid(s)){
                ans.add(s);
            }
            return;
        }
        solve(s+"(", n, ans);
        solve(s+")", n, ans);
    }
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    if(stack.peek() != '('){
                        return false;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}