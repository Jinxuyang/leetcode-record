package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2020/11/8 15:06
 * @Version 1.0
 */
public class Leetcode350 {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect2(nums1, nums2)));
    }

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了70.92%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了5.13%的用户
     * 思路：
     * 1. 统计第一个数组各个数组的出现次数，使用hashmap存储
     * 2. 遍历第二个数组，如果出现hashmap中存在的则将该数存在数组中，并将该数的出现次数-1
     * 3. 返回数组
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] temp;
        if(nums1.length > nums2.length) temp = new int[nums2.length];
        else temp = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        int cnt = 0;
        for (int i : nums2) {
            if (map.containsKey(i)) {
                if (map.get(i) > 0){
                    temp[cnt] = i;
                    map.put(i,map.get(i)-1);
                    cnt ++;
                }
            }
        }
        int[] r = new int[cnt];
        for(int i = 0;i < cnt;i++) r[i] = temp[i];
        return r;
    }
    /**
     * 空间复杂度优化：
     * 1. 可以遍历较短的数组把数组信息存在hashmap中
     * 时间复杂度优化：
     * 1. 在第二次遍历时当数字的出现个数小于或等于1时将其去除，以减少下次搜索map的时间(貌似没用hashmap的操作的时间复杂度是O(1))
     * 其他优化：
     * 1. 用getOrDefault方法代替
     * if (map.containsKey(i)) map.put(i,map.get(i)+1);
     * else map.put(i,1);
     * 2.使用Arrays.copyOfRange(temp,0,cnt)代替那一大串
     *
     * 执行用时：3 ms, 在所有 Java 提交中击败了70.92%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了97.82%的用户
     */

    public static int[] intersect1(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect1(nums2,nums1);
        int[] temp = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums1) {
           int count = map.getOrDefault(i,0) + 1;
           map.put(i,count);
        }
        int cnt = 0;
        for (int i : nums2) {
            int count = map.getOrDefault(i,0);
            if (count > 0){
                temp[cnt] = i;
                cnt++;
                if (count - 1 <= 0) map.remove(i);
                else map.put(i,count-1);
            }
        }
        return Arrays.copyOfRange(temp,0,cnt);
    }

    /**
     * 方法二：双指针
     * 思路：
     *  1. 先将两个数组进行排序
     *  2. 使用两个指针分别遍历两个数组，当两个数相等时输出到答案，不相等的话将小的那个数的指针往前移动一位
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了74.24%的用户
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        // 对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int x = 0,y = 0,cnt = 0;
        int[] temp = new int[Math.min(nums1.length,nums2.length)];
        while (x < nums1.length && y < nums2.length){
            if (nums1[x] == nums2[y]){
                temp[cnt] = nums1[x];
                y++;
                x++;
                cnt++;
            } else {
                if (nums1[x] > nums2[y]){
                    y++;
                } else {
                    x++;
                }
            }
        }
        return Arrays.copyOfRange(temp,0,cnt);
    }
}
