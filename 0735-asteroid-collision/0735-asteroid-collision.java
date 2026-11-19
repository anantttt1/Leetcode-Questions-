class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int a:asteroids){
            boolean flag = true;
            while(flag && a<0 && !st.isEmpty() && st.peek()>0){
                if(st.peek()<-a){
                    st.pop();
                } else if (st.peek() == -a){
                    st.pop();
                    flag=false;
                }else{
                    flag=false;
                }
            }
            if(flag){
                st.push(a);
            }
        }
        int[] ans=new int[st.size()];
        for(int i=0;i<st.size();i++){
            ans[i]=st.get(i);
        }
        return ans;
    }
}
