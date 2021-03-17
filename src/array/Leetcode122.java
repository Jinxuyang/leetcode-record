package array;

/**
 * @Author Verge
 * @Date 2021/3/13 20:53
 * @Version 1.0
 */
public class Leetcode122 {
    public static void main(String[] args) {
        int[] input = {};
        System.out.println(maxProfit(input));
    }

    /**
     * 思路：
     * 1. 贪心，比较两天之间的价格差，若小于等于0不操作，大于零就在当天买入，在第二天卖出
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.59%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了53.78%的用户
     */
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i+1]){
                res+=prices[i+1]-prices[i];
            }
        }
        return res;
    }
}
