// Question Link : https://leetcode.com/problems/backspace-string-compare/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '#'){
                if(!stackS.isEmpty()){
                    stackS.pop();
                }
            }
            else{
                stackS.push(c);
            }
        }
        for(char c : t.toCharArray()){
            if(c == '#'){
                if(!stackT.isEmpty()){
                    stackT.pop();
                }
            }
            else{
                stackT.push(c);
            }
        }
        StringBuilder sbS = new StringBuilder();
        for(char val : stackS){
            sbS.append(val);
        }
        StringBuilder sbT = new StringBuilder();
        for(char val : stackT){
            sbT.append(val);
        }
        return sbS.toString().equals(sbT.toString());
    }
}