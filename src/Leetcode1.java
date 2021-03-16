import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2021/3/16 19:00
 * @Version 1.0
 */
public class Leetcode1 {
    public static void main(String[] args) {
        int[] input = {3,3};
        System.out.println(Arrays.toString(twoSum1(input, 6)));
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了88.80%的用户
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            res[0] = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[1] = j;
                    return res;
                }
            }
        }
        return null;
    }

    /**
     * 思路：
     * 1. 使用hashmap，key存为nums[i],value存为i
     * 2. 遍历数组如果map中含有target - nums[i]这个键说明nums[i]与次数相加结果就为target
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了85.25%的用户
     */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(nums.length - 1);
        map.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[] {map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }

        return null;
    }
}
