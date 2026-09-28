class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int count[]=new int[nums.length];
        int ans[]=new int[2];
        int j=0;
        for(int num:nums){
            count[num]++;
            if(count[num]==2){
                ans[j]=num;
                j++;
            }
        }
        return ans;
    }
}