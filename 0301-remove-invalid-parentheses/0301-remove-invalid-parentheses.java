import java.util.*;
public class Solution {
    public List<String> removeInvalidParentheses(String s){
        List<String> res=new ArrayList<>();
        Set<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add(s);
        visited.add(s);
        boolean found=false;
        while(!q.isEmpty()){
            String curr=q.poll();
            if(isValid(curr)){
                res.add(curr);
                found=true;
            }
            if(found)continue;
            for(int i=0;i<curr.length();i++){
                if(curr.charAt(i)!='(' &&curr.charAt(i)!=')')continue;
                String next=curr.substring(0,i)+curr.substring(i+1);
                if(!visited.contains(next)){
                    q.add(next);
                    visited.add(next);
                }
            }
        }
        return res;
    }
    private boolean isValid(String str){
        int count=0;
        for(char c : str.toCharArray()){
            if(c=='(')count++;
            else if(c== ')'){
                if(count ==0) return false;
                count--;
            }
        }
        return count==0;
    }
}
