package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Verge
 * @Date 2022/3/30 15:24
 * @Version 1.0
 */
public class Code128 {
    public static void main(String[] args) {
        Code128 code128 = new Code128();
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(code128.longestConsecutive1(nums));
        System.out.println(code128.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int res = 0;
        for (Integer num : set) {

            if (!set.contains(num - 1)) {
                int i = 1;
                while (set.contains(num + i)) {
                    i++;
                }
                res = Math.max(i, res);
            }
        }

        return res;
    }

    public int longestConsecutive1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int cur = left + right + 1;
            map.put(num, cur);

            map.put(num - left, cur);
            map.put(num + right, cur);

            res = Math.max(res, cur);
        }
        return res;
    }
}
