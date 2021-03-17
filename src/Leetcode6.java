import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2021/3/17 10:56
 * @Version 1.0
 */
public class Leetcode6 {
    public static void main(String[] args) {
        String input = "AB";
        System.out.println(convert(input, 1));
    }

    /**
     * 模拟
     * 思路：https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-cshi-xian-liang-chong-jie-fa-m/
     */
    public static String convert(String s, int numRows) {
        String[] temp = new String[numRows];
        Arrays.fill(temp, "");

        if (numRows == 1) return s;
        int pos = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            temp[pos] += s.charAt(i);
            if (flag) pos++;
            else pos--;
            if (pos == 0) flag = true;
            else if (pos == numRows - 1) flag = false;
        }
        StringBuilder res = new StringBuilder();
        for (String value : temp) {
            res.append(value);
        }
        return res.toString();

    }
}
