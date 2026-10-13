class Solution {
    public int maxProduct(int n) {
        int max=0;
        int m=0;
        while(n>0){
            int d=n%10;
            if(d>max){
                m=max;
                max=d;
            }else if(d>m){
                m=d;
            }
            n/=10;
        }
        return m*max;
    }
}