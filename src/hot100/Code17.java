package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Verge
 * @Date 2022/3/19 23:34
 * @Version 1.0
 */
public class Code17 {
    public static void main(String[] args) {
        Code17 code17 = new Code17();
        System.out.println(code17.letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        String[] charArray = new String[digits.length()];
        char[] nums = digits.toCharArray();
        final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = map[nums[i] - 48];
        }

        get(charArray, 0, "", res);

        return res;
    }

    public static void get(String[] nums, int index, String str, List<String> res) {
        if (index > (nums.length - 1)) {
            res.add(str);
            return;
        }

        char[] cs = nums[index].toCharArray();
        for (int i = 0; i < nums[index].length(); i++) {
            get(nums, index + 1, str + cs[i], res);
        }
    }

}
