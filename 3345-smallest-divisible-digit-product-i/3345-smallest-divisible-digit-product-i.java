class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int x=n;
            int pro=1;
            while(x>0){
                pro*=x%10;
                x/=10;
            }
            if(pro%t==0){
            return n;
        }
        n++;
        }
    }
}