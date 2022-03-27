package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Verge
 * @Date 2022/3/27 15:33
 * @Version 1.0
 */
public class Code39 {
    public static void main(String[] args) {
        Code39 code39 = new Code39();
        int[] nums = {2,3,6,7};
        System.out.println(code39.combinationSum(nums, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        get(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    public void get(int[] candidates, int rem, List<Integer> list, int index) {
        if (rem == 0) {
            res.add(list);
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (rem - candidates[i] >= 0) {
                list.add(candidates[i]);
                get(candidates, rem - candidates[i], new ArrayList<>(list), i);
                list.remove((Object)candidates[i]);
            } else {
                break;
            }
        }
    }
}
