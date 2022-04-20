package array;

import java.util.HashMap;

/**
 * @Author Verge
 * @Date 2022/4/20 11:16
 * @Version 1.0
 */
public class Leetcode560 {
    public static void main(String[] args) {
        Leetcode560 leetcode560 = new Leetcode560();
        System.out.println(leetcode560.subarraySum(new int[]{1, -1, 0}, 0));
    }
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0;i < prefix.length;i++) {
            if(i == 0) prefix[i] = nums[i];
            else prefix[i] = prefix[i - 1] + nums[i];
        }

        int res = 0;
        for(int i = 0;i < nums.length;i++) {
            int toFind = prefix[i] - k;
            if (map.containsKey(toFind)) {
                res += map.get(toFind);
            }
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }

        return res;
    }
}
