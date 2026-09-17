class Solution {
    public int minimumSum(int num) {
        int digit[]=new int[4];
        for(int i=0;i<4;i++){
            digit[i]=num%10;
            num/=10;
        }
        Arrays.sort(digit);
        return digit[0]*10+digit[2]+digit[1]*10+digit[3];
    }
}