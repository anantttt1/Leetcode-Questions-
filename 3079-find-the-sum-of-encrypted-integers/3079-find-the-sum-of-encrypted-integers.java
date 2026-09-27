class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int count=0;
        for(int num:nums){
            int max=0;
            int n=num;
            while(num!=0){
                int d=num%10;
                max=Math.max(d,max);
                num/=10;
            }
            if(n<10){
                count+=max;
            }else if(n>9 && n<100){
                count+=(max*10)+max;
            }else if(n>99 && n<1000){
                count+=(max*100)+(max*10)+max;
            }else{
                count+=(max*1000)+(max*100)+(max*10)+max;
            }
        }
        return count;
    }
}