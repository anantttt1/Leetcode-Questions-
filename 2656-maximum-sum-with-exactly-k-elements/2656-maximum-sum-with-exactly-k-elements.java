class Solution {
    public int maximizeSum(int[] nums, int k){
        int max=0;
        for(int x : nums)
            max=Math.max(max,x);
        return k*max+k*(k-1)/2;
    }
}