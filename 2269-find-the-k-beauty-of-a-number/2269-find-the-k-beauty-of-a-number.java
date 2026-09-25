class Solution {
    public int divisorSubstrings(int num, int k) {
        int count=0;
        int a=num;
        int b=1;
        for(int i=0;i<k;i++){
            b*=10;
        }
        while(a>=b/10){
            int digit=a%b;
                if(digit!=0 && num%digit==0){
                count++;
            }
            a/=10;
        }
        return count;
    }
}