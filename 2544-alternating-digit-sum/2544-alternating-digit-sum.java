class Solution {
    public int alternateDigitSum(int n) {
        int digits = 0;
        int temp = n;
        while(temp != 0) {
            digits++;
            temp /= 10;
        }
        int sum = 0;
        int count = 0;
        while(n != 0) {
            int digit = n % 10;
            if(digits % 2 == 0) {
                if(count % 2 == 0)
                    sum -= digit;
                else
                    sum += digit;
            } else {
                if(count % 2 == 0)
                    sum += digit;
                else
                    sum -= digit;
            }
            count++;
            n /= 10;
        }
        return sum;
    }
}