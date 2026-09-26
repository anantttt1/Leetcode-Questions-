class Solution {
    public int minimumOperations(int[] nums) {
        int ans=0;
        for(int n:nums){
            int r=n%3;
            if(r!=0){
                ans+=Math.min(r,3-r);
            }
        }
        return ans;
    }
}