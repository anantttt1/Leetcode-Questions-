class Solution {
    public int numberOfSteps(int num) {
        if(num==0) return 0;
        return Integer.bitCount(num)+(31-Integer.numberOfLeadingZeros(num));
    }
}
