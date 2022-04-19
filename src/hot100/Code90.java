package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Verge
 * @Date 2022/4/19 16:16
 * @Version 1.0
 */
public class Code90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        recur(nums, 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public void recur(int[] nums,int start) {
        res.add(new ArrayList(list));

        for(int i = start;i < nums.length;i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            list.add(nums[i]);
            recur(nums, i + 1);
            list.remove((Object)nums[i]);
        }
    }
}
