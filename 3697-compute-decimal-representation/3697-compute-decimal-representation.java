class Solution {
    public int[] decimalRepresentation(int n) {
        int count=0;
        int t=n;
        while(t!=0){
            if(t%10!=0){
            count++;}
            t/=10;
        }
        int arr[]=new int[count];
        int mul=1;
        int index=count-1;
        while(n!=0){
            int digit=n%10;
            if(digit!=0){
                arr[index]=digit*mul;
                index--;
            }
            n/=10;
            mul*=10;
        }
        return arr;
    }
}