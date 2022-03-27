package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Verge
 * @Date 2022/3/27 16:20
 * @Version 1.0
 */
public class Code46 {
    public static void main(String[] args) {
        Code46 code46 = new Code46();
        int[] nums = {1,2,3};
        System.out.println(code46.permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        get(nums, visited, new ArrayList<>());
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    public void get(int[] candidates, boolean[] visited, List<Integer> list) {
        if (list.size() == candidates.length) {
            res.add(list);
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (!visited[i]) {
                list.add(candidates[i]);
                visited[i] = true;
                get(candidates, visited, new ArrayList<>(list));
                visited[i] = false;
                list.remove((Object)candidates[i]);
            }
        }
    }
}
