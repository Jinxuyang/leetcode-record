package array;

/**
 * @Author Verge
 * @Date 2022/4/20 12:39
 * @Version 1.0
 */
public class Leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) return new int[]{left + 1, right + 1};
            else if(sum < target) left++;
            else if(sum > target) right--;
        }
        return new int[]{-1, -1};
    }
}
