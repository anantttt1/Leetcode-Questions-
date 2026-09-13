class Solution {
    public int arraySign(int[] nums) {
        int n=0,z=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]<0){
            n++;
           }else if(nums[i]==0){ 
            z++;
            }
        }
        if(z>0) {
            return 0;
        }else if(n%2==0 && z==0){
            return 1;
        }else {
            return-1;
        }
        
    }
}