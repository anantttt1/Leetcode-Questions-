class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left= 0;
        int maxCount = 0;
        int maxLength = 0;
        for (int r = 0; r < s.length(); r++) {
            int index = s.charAt(r) - 'A';
            freq[index]++;
            maxCount = Math.max(maxCount, freq[index]);
            while ((r - left + 1) - maxCount > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, r - left + 1);
        }
        return maxLength;
    }
}
