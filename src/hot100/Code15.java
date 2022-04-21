package hot100;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Verge
 * @Date 2022/4/21 12:08
 * @Version 1.0
 */
public class Code15 {
    public static void main(String[] args) {
        Code15 code15 = new Code15();
        System.out.println(code15.threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i < nums.length - 2;) {
            int start = nums[i];
            int target = -nums[i];
            int L = i + 1, R = nums.length - 1;
            while(L < R) {
                int left = nums[L], right = nums[R];
                int sum = left + right;
                if(sum == target) {
                    res.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while(L < R && nums[L] == left) L++;
                    while(L < R && nums[R] == right) R--;
                } else if(sum > target) {
                    while(L < R && nums[R] == right) R--;
                } else {
                    while(L < R && nums[L] == left) L++;
                }
            }
            while(i < nums.length && nums[i] == start) i++;
        }
        return res;
    }
}
