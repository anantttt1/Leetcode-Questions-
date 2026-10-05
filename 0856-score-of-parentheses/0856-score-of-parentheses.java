import java.util.Stack;
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(0); 
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(0);
            }else{
                int currentScore=stack.pop();
                int outerScore =stack.pop();
                int newScore=outerScore +Math.max(2 *currentScore,1);
                stack.push(newScore);
            }
        }
        
        return stack.pop();
    }
}
