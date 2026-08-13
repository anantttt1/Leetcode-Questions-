class Solution {
    public int findNumbers(int[] nums) {
       int count = 0;
       for(int n : nums){
        int digits = String.valueOf(n).length();
        if(digits % 2==0){
            count++;
        } 
       } 
       return count;
    }
}