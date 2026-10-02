class Solution {
    public int countDigits(int n) {
        int x=n,c=0;
        while(x>0){
            int d=x%10;
            if(d!=0 && n%d==0)
            c++;
            x/=10;
        }
        return c;
    }
}