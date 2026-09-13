class Solution {
    public int sumBase(int n, int k) {
        int last= 0;
        int sum =0;
        while(n!=0) {
            last=n%k;
            sum=sum+last;
            n=n/k;
        }
        return sum;
    }
}