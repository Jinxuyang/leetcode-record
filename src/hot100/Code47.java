package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Verge
 * @Date 2022/3/25 20:39
 * @Version 1.0
 */
public class Code47 {

    public static void main(String[] args) {
        Code47 code47 = new Code47();
        int[] nums = {2,2,1,1};
        System.out.println(code47.permuteUnique(nums));
    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        get(arr, new ArrayList<>());
        return res;
    }

    public void get(List<Integer> nums, List<Integer> list) {
        if (list.size() <= 0) {
            res.add(list);
        }

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            list.add(num);
            nums.remove((Object)num);
            get(nums, list);
            list.remove((Object)num);
            nums.add(num);
        }
    }

    public List<List<Integer>> permuteUnique1(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        recur1(nums, visited);
        return res;
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public void recur1(int[] nums, boolean[] visited) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0;i < nums.length;i++) {
            if(visited[i]) continue;

            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            list.add(nums[i]);
            visited[i] = true;
            recur1(nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
