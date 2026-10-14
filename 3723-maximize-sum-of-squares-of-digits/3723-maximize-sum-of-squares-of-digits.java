public class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (num * 9 < sum) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int numNines = sum / 9;
        int remainder = sum % 9;
        int digitsUsed = numNines + (remainder > 0 ? 1 : 0);
        for (int i = 0; i < numNines; i++) {
            sb.append('9');
        }
        if (remainder > 0) {
            sb.append(remainder);
        }
        int remainingZeros = num - digitsUsed;
        for (int i = 0; i < remainingZeros; i++) {
            sb.append('0');
        }
        return sb.toString();
    }
}
