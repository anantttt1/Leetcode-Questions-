public class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if (n==2){
            return s.charAt(0)<=s.charAt(1) ? 0 :-1;
        }
        boolean sorted = true;
        for(int i=1;i<n;i++){
            if(s.charAt(i)<s.charAt(i-1)){
                sorted=false;
                break;
            }
        }
        if(sorted){
            return 0;
        }
        char minChar ='z'+1;
        char maxChar ='a'-1;
        int minIdx=-1;
        int maxIdx=-1;
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c<minChar){
                minChar=c;
                minIdx=i;
            }
            if(c>=maxChar){
                maxChar=c;
                maxIdx=i;
            }
        }
        if(minIdx==0 || maxIdx==n -1){
            return 1;
        }
        if(minIdx ==n-1 && maxIdx== 0){
            return 3;
        }
        return 2;
    }
}