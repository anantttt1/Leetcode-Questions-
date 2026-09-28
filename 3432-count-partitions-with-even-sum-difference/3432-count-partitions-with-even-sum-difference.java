class Solution {
    public int countPartitions(int[] nums) {
        int count=0;
        int first=0;
        int total=0;
        for(int num:nums){
            total+=num;
        }
        for(int i=0;i<nums.length-1;i++){
            first+=nums[i];
            int second=total-first;
            if((first-second)%2==0){
                count++;
            }
        }
        return count;
    }
}