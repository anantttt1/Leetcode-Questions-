class Solution {
    public int totalMoney(int n) {
        int ans = 0;
        int week = 0;
        int day = 0;
        for (int i = 1; i <= n; i++) {
            ans += week + day + 1;
            day++;
            if (day == 7) {
                day = 0;
                week++;
            }
        }
        return ans;
    }
}