// import java.util.List;
class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        return checkAcronymRecursive(words, s, 0);
    }
    private boolean checkAcronymRecursive(List<String> words, String s, int index) {
        if (index == words.size()) {
            return true;
        }
        if (words.get(index).charAt(0) != s.charAt(index)) {
            return false;
        }
        return checkAcronymRecursive(words, s, index + 1);
    }
}
