class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int a=-1;
        int b=-1;
            if((coordinate1.charAt(0)+coordinate1.charAt(1))%2!=0){
                a=1;
            }else{
                a=0;
            }
            if((coordinate2.charAt(0)+coordinate2.charAt(1))%2!=0){
                b=1;
            }else{
                b=0;
            }
            if(a==b){
                return true;
            }else{
                return false;
            }
    }
}