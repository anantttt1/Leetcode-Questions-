import java.util.Stack;
class Solution {
    public String reverseParentheses(String s){
        Stack<Integer> openBracketsIndexes=new Stack<>();
        StringBuilder res=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='(') {
                openBracketsIndexes.push(res.length());
            } else if(ch==')'){
                int start=openBracketsIndexes.pop();
                reverse(res, start, res.length()-1);
            } else{
                res.append(ch);
            }
        }
        return res.toString();
    }
    private void reverse(StringBuilder sb, int start, int end){
        while(start< end){
            char temp=sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
