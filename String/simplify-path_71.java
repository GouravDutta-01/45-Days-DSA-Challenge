// Question Link : https://leetcode.com/problems/simplify-path/
class Solution {
    public String simplifyPath(String path) {
        String[] words = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String word : words){
            if(word.equals("") || word.equals(".")){
                continue;
            }
            else if(word.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(word);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        String ans = "";
        while(!stack.isEmpty()){
            ans = "/" + stack.pop() + ans;
        }
        return ans;     
    }
}