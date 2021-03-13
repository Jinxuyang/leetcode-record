/**
 * @Author Verge
 * @Date 2021/3/12 17:59
 * @Version 1.0
 */
public class Leetcode14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix1(strs));
    }

    /**
     * 思路：
     *  1. 双重循环，第一层循环遍历一个字符串的各个位，里面套一层遍历字符串数组的每个字符串
     *  2. 在遍历过程中用每一个字符串的第i位和第一个字符串的第i位进行比较，都相同的话输出到答案，有一个不相同就结束程序
     *
     *  执行用时：1 ms, 在所有 Java 提交中击败了83.96%的用户
     *  内存消耗：36.4 MB, 在所有 Java 提交中击败了81.53%的用户
     */
    public static String longestCommonPrefix(String[] strs) {
        // 处理空字符串数组这一特殊情况
        if (strs.length <= 0) return "";
        StringBuilder res = new StringBuilder();
        for (int j = 0; j < strs[0].length(); j++) {
            boolean flag = true;
            for (String str : strs) {
                if (j >= str.length() || strs[0].charAt(j) != str.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.append(strs[0].charAt(j));
            else break;
        }
        return res.toString();
    }

    /**
     * 思路：
     * 1. 以字符串数组中的第一个字符串作为最长公共前缀
     * 2. 依次和字符串数组里的下一个字符串比较，求其最长公共前缀，作为新的最长公共前缀，重复此过程即可得到答案
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length <= 0) return "";
        String prefix = strs[0];
        for (String str : strs){
            prefix = longestCommonPrefix(prefix,str);
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1,String str2){
        int cnt = Math.min(str1.length(),str2.length());
        int res = 0;
        while (res < cnt && str1.charAt(res) == str2.charAt(res)){
            res++;
        }

        return str1.substring(0,res);
    }


}
