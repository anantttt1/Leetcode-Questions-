class Solution {
    public String convertDateToBinary(String date) {
        String []s=date.split("-");
        int year=Integer.parseInt(s[0]);
        int month=Integer.parseInt(s[1]);
        int day=Integer.parseInt(s[2]);
        return Integer.toBinaryString(year)+"-"+Integer.toBinaryString(month)+"-"+Integer.toBinaryString(day);
    }
}