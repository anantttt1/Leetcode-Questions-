class Solution {
    public List<String> commonChars(String[] words) {
        int[] minCounts = new int[26];
        java.util.Arrays.fill(minCounts, Integer.MAX_VALUE);
        for (String word : words) {
            int[] counts = new int[26];
            for (char c : word.toCharArray()) counts[c - 'a']++;
            for (int i = 0; i < 26; i++) minCounts[i] = Math.min(minCounts[i], counts[i]);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minCounts[i]-- > 0) {
                result.add(String.valueOf((char)(i + 'a')));
            }
        }
        return result;
    }
}
