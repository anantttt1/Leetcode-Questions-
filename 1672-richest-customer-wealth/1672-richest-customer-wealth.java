class Solution {
    public int maximumWealth(int[][] accounts) {
      int max=0;
      for(int[] row:accounts ){
        int sum=0;
        for(int x:row)
        sum+=x;
        max=Math.max(max,sum);
      }  
      return max;
    }
}