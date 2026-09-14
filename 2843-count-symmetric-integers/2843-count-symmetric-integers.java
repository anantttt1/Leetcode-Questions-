class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int n = low; n <= high; n++) {
            if (n >= 10 && n <= 99) {
                if (n / 10 == n % 10) {
                    count++;
                }
            }
            if (n >= 1000 && n <= 9999) {
                int a = n / 1000;
                int b = (n / 100) % 10;
                int c = (n / 10) % 10;
                int d = n % 10;
                if (a + b == c + d) {
                    count++;
                }
            }
        }
        return count;
    }
}