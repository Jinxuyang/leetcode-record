package string;

public class Leetcode796 {
    public static void main(String[] args) {
        Leetcode796 leetcode796 = new Leetcode796();
        System.out.println(leetcode796.rotateString("gcmbf", "fgcmb"));

    }

    /**
     * 思路：1. 两个指针，分别指向两个字符串
     *      2. 一个指针始终保持指向第一个字符，另一个从第一个开始，要是相同两个指针同时向后移动，要是不同第一个指针回到0，另一个指针从上次开始的
     *      后一个开始
     *      3. 如此循环chars.length次，就把所有结果都便利了一边，中途要是有那一组把goalChars循环完了的话说明符合要求，要是chars.length次
     *      循环完了还是没有符合要求的说明这个不符合题目要求
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
