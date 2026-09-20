class Solution{
public int reverseDegree(String s){
int totalReverseDegree=0;
int len=s.length();
for(int i=0;i<len;i++){
int position=i+1;
int reverseAlphabetValue=26-(s.charAt(i)-'a');
totalReverseDegree+=position*reverseAlphabetValue;
}
return totalReverseDegree;
}
}
