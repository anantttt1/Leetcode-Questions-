class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);

    }
    private int atmost(int[]nums,int k){
        int oddC=0, l=0 ,count=0;
        for(int r=0; r<nums.length;r++){
            if(nums[r]%2==1){
                oddC++;
            }
            while(oddC>k){
                if(nums[l] %2==1){
               oddC--;
            }
             l++;
        }
        count+=r-l+1;
    }
    return count;
}
}