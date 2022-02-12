package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2022/2/12 20:20
 * @Version 1.0
 */
public class JZOffer39 {
    public static void main(String[] args) {
        JZOffer39 jzOffer39 = new JZOffer39();
        int[] x = {3, 2, 3};
        System.out.println(jzOffer39.majorityElement3(x));
    }
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer val = map.get(num);
                val++;
                map.put(num, val);
            } else {
                map.put(num, 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length / 2) return key;
        }

        return -1;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int zs = nums[i];
            int vote = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (zs == nums[j]) vote++;
                else vote--;
                if (vote == 0) {
                    i = j;
                    break;
                }
            }
            if (vote != 0) return zs;
        }
        return -1;
    }

    public int majorityElement4(int[] nums) {
        int x = 0, vote = 0;
        for (int num : nums) {
            if (vote == 0) x = num;
            vote += num == x ? 1 : -1;
        }
        return x;
    }
}
