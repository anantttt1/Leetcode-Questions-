class Solution {
    public int differenceOfSum(int[] nums) {
        int sum=0;
        int summ=0;
        for(int num:nums){
            sum+=num;
            while(num!=0){
                int d=num%10;
                summ+=d;
                num/=10;
            }
        }
        return Math.abs(sum-summ);
    }
}