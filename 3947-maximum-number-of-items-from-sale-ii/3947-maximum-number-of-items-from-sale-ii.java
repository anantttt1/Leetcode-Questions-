
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] gain = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                gain[i] += freq[j];
            }
            gain[i]--;
        }

        TreeMap<Integer, Long> map = new TreeMap<>();

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if (price < 2L * minPrice && gain[factor] > 0) {
                map.merge(price, (long) gain[factor], Long::sum);
            }
        }

        long ans = 0;
        long money = budget;

        for (int price : map.keySet()) {
            long count = Math.min(map.get(price), money / price);
            ans += count * 2;
            money -= count * price;
        }

        ans += money / minPrice;

        return (int) ans;
    }
}
