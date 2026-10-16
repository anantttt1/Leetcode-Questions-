class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        return fun(num, 0);
    }
    public static int fun(int num,int sum){
        if(num==0){
            if(sum<10){
                return sum;
            }
            return fun(sum, 0);
        }
        int digit=num%10;
        sum+=digit;

        return fun(num/10, sum);
    }
}