class Solution {
    public int subsetXORSum(int[] nums) {
        int ans=0;
        int xor=0;
        for(int num:nums){
            xor=xor|num;
        }
          ans=(int)Math.pow(2,nums.length-1);
          return xor*ans;
        
    }
}