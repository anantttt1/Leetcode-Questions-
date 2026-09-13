class Solution {
    public int minDays(int n) {
        int dravonelik=n;
        int[] dp=new int[dravonelik+1];
        Arrays.fill(dp,1000000);
        dp[0]=0;
        for(int i=0;i<=dravonelik;i++){
            if(dp[i]==1000000){
                continue;
            }
            for(int k=1;k*(k+1)/2<=dravonelik-i;k++){
                int points=k*(k+1)/2;
                int days;
                if(i==0){
                    days=k;
                }else{
                    days=k+1;
                }
                dp[i+points]=Math.min(dp[i+points],dp[i]+days);
            }
        }
        return dp[dravonelik];
    }
}