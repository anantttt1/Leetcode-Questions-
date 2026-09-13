class Solution {
    public int countSpecialIntegers(int[] nums) {
        int ans=0;
        HashSet<Integer> set=new HashSet<>();
        for(int x: nums){
            if(set.contains(x)){
                continue;
            }
            set.add(x);
            int count=0;
            int first=-1,second=-1,third=-1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==x){
                    count++;
                    if(count==1) first=i;
                    else if(count==2) second=i;
                    else if(count==3) third=i;
                }
            }
            if(count==3 && second-first==third-second){
                ans++;
            }
        }
        return ans;
    }
}