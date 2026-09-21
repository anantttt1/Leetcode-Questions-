class Solution {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            int len = sb.length();
            if (len >= 3 && sb.substring(len - 3).equals("abc")) {
                sb.setLength(len - 3); // Delete the last "abc"
            }
        }
        return sb.length() == 0;
    }
}
