package bit;

/**
 * @Author Verge
 * @Date 2021/12/19 14:12
 * @Version 1.0
 */
public class JZOffer15 {
    /**
     * 思路：位运算，用1和n进行与操作，结果是一说明这一位是1，然后将n无符号右移一位（有符号，负数时会致死循环）
     */
    public static int hammingWeight(int n) {
        int cnt = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                cnt++;
            }
            n = n >>> 1; // >>> 为无符号右移
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }


}
