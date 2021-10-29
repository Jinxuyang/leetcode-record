package array;

/**
 * @Author Verge
 * @Date 2021/10/29 14:42
 * @Version 1.0
 */
public class JZOffer11 {
    public static void main(String[] args) {
        JZOffer11 jzOffer11 = new JZOffer11();
        int[] array = {10,1,10,10,10};
        System.out.println(jzOffer11.minArray(array));
    }

    /**
     *  思路：旋转数组可以分为左右两个序列，左序列的每一个元素都比又序列大，这道题实际找的就是右序列的第一个值
     *       考虑可以使用二分法查找，二分法的本质是去掉无用的区间
     *       当mid大于numbers[rear]时说明mid处于左序列，说明区间[head,mid]是无用的，应该将head指向mid+1
     *       当mid小于numbers[rear]说明mid处于右序列，区间(mid,rear]是无用的，应将rear指向mid
     *       当mid等于numbers[rear]时，无法判断mid处于那个序列，自然也无法通过二分法安全地缩小区间，执行 j = j - 1 缩小判断范围（没搞明白Why）
     *       当head和rear重合时结束循环
     **/
    public int minArray(int[] numbers) {
        if (numbers.length == 1) return numbers[0];

        int head = 0;
        int rear = numbers.length - 1;
        while (head < rear) {
            int mid = (head + rear) / 2;

            if (numbers[mid] > numbers[rear]) {
                head = mid + 1;
            } else if (numbers[mid] < numbers[rear]){
                rear = mid;
            } else if(numbers[mid] == numbers[rear]){
                rear--;
            }
        }

        return numbers[head];
    }
}
