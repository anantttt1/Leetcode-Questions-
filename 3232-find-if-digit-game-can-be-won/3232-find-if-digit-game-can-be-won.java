class Solution {
    public boolean canAliceWin(int[] nums) {
       int d=0,single=0;
       for(int num:nums){
        if(num<10){
            single+=num;
        }else{
            d+=num;
        }
       }
       return single<d || d<single;
    }
}