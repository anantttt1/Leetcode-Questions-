class Solution {
    public boolean isMonotonic(int[] nums) {
        int inc=0;
        int dec=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                dec++;
            }else if(nums[i]>nums[i-1]){
                inc++;
            }
        }
        if(dec==0 || inc==0){
            return true;
        }else{
            return false;
        }
    }
}