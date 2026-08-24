class Solution {
    public int lengthOfLastWord(String s) {
     String arr[] = s.split(" ");
     String lastward = arr[arr.length-1];
     return lastward.length();  
    }
}