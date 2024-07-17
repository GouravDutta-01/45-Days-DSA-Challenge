// Question Link : https://www.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> stack = new Stack<>();
        for(char ch : S.toCharArray()){
            if(!Character.isDigit(ch)){
                int a = stack.pop();
                int b = stack.pop();
                if(ch == '*'){
                    stack.push(a*b);
                }
                else if(ch == '/'){
                    stack.push(b/a);
                }
                else if(ch == '+'){
                    stack.push(a+b);
                }
                else if(ch == '-'){
                    stack.push(b-a);
                }
            }
            else{
                stack.push((int)(ch-'0'));
            }
        }
        return stack.peek();
    }
}