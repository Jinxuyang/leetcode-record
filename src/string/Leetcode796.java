package string;

public class Leetcode796 {
    public static void main(String[] args) {
        Leetcode796 leetcode796 = new Leetcode796();
        System.out.println(leetcode796.rotateString("gcmbf", "fgcmb"));

    }

    /**
     * 思路：
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        char[] chars = s.toCharArray();
        char[] goalChars = goal.toCharArray();
        boolean flag = true;
        if (chars.length != goalChars.length) {
            return false;
        }
        for (int k = 0; k < chars.length; k++) {
            int i = k;
            int j = 0;
            while (chars[i] == goalChars[j]) {
                if (i + 1 < chars.length && j + 1 < goalChars.length){
                    i++;
                    j++;
                } else if (i + 1 == chars.length && flag) {
                    flag = false;
                    i = 0;
                    j++;
                } else if (i == k - 1 || j + 1 < goalChars.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
