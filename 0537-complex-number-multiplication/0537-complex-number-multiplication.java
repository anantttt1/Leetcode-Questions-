class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] x = a.replace("i", "").split("\\+");
        String[] y = b.replace("i", "").split("\\+");
        int a1 = Integer.parseInt(x[0]);
        int b1 = Integer.parseInt(x[1]);
        int a2 = Integer.parseInt(y[0]);
        int b2 = Integer.parseInt(y[1]);
        return (a1*a2 - b1*b2) + "+" + (a1*b2 + b1*a2) + "i";
    }
}