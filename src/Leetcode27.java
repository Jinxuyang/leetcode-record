import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2021/3/15 19:02
 * @Version 1.0
 */
public class Leetcode27 {
    public static void main(String[] args) {
        int[] input = {0,1,2,2,3,0,4,2};
        removeElement1(input,2);
    }

    /**
     * 思路：
     * 1. 遍历数组，遇到和val相同的数时，将这个数前边的所有数向前移动一位
     * 2. 并从这个数开始继续遍历，重复以上操作
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37 MB, 在所有 Java 提交中击败了64.21%的用户
     */
    public static int removeElement(int[] nums, int val) {
        int cnt = nums.length;
        for (int i = 0; i < cnt; i++) {
            if (nums[i] == val){
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j+1];
                }
                //保证i不变化
                i--;
                //数组内有效数字-1
                cnt--;
            }
        }
        /*System.out.println(cnt);
        System.out.println(Arrays.toString(nums));*/
        return cnt;
    }


    /**
     * 思路：
     * 1. 使用两个指针，一个指向数组前=头，一个尾
     * 2. 遍历数组，遇到和val相同的则与nums[rear]进行交换，并使rear向前移动一位
     * 3. 继续从交换后的这个数上遍历，重复以上过程
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37 MB, 在所有 Java 提交中击败了68.13%的用户
     */
    public static int removeElement1(int[] nums, int val) {
        int rear = nums.length - 1,cnt = nums.length;
        for (int i = 0; i < cnt; i++) {
            if (nums[i] == val){
                nums[i] = nums[rear];
                rear--;
                i--;
                cnt--;
            }
        }
        /*System.out.println(cnt);
        System.out.println(Arrays.toString(nums));*/
        return cnt;
    }
}
