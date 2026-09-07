import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        // 1. Ek word ki length aur total words ka count nikalna
        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        int sLen = s.length();

        if (sLen < totalLen) return result;

        // 2. Sabhi words ki frequency ka map banana
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // 3. Sliding Window track (wordLen ke barabar loops chalenge)
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> seenMap = new HashMap<>();
            int count = 0;

            while (right + wordLen <= sLen) {
                // Window mein agla word nikalna
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordMap.containsKey(sub)) {
                    seenMap.put(sub, seenMap.getOrDefault(sub, 0) + 1);
                    count++;

                    // Agar koi word limit se zyada baar aa jaye, toh window left se choti karein
                    while (seenMap.get(sub) > wordMap.get(sub)) {
                        String leftSub = s.substring(left, left + wordLen);
                        seenMap.put(leftSub, seenMap.get(leftSub) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Agar saare words match ho gaye
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    // Agar koi anjaan word mila, toh window reset karein
                    seenMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
