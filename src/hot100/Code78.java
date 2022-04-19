package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Verge
 * @Date 2022/3/29 10:50
 * @Version 1.0
 */
public class Code78 {
    public static void main(String[] args) {
        Code78 code78 = new Code78();
        int[] nums = {1};
        System.out.println(code78.subsets(nums));
    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        recur(nums, 0, new ArrayList<>());
        return res;
    }

    public void recur(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            res.add(list);
            return;
        }

        list.add(nums[index]);
        recur(nums, index + 1, new ArrayList<>(list));
        list.remove(list.size() - 1);
        recur(nums, index + 1, new ArrayList<>(list));
    }

    public void recur1(int[] nums, int index, List<Integer> list) {
        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            recur1(nums, index + 1, new ArrayList<>(list));
            list.remove(list.size() - 1);

        }
    }



}
