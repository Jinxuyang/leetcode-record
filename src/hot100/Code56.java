package hot100;

import java.util.*;

/**
 * @Author Verge
 * @Date 2022/3/28 19:21
 * @Version 1.0
 */
public class Code56 {
    public static void main(String[] args) {
        Code56 code56 = new Code56();
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}} ;
        System.out.println(Arrays.deepToString(code56.merge(nums)));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (index == -1) {
                res.add(new int[]{intervals[i][0], intervals[i][1]});
                index++;
                continue;
            }

            int[] temp = res.get(index);
            if (intervals[i][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                res.add(new int[]{intervals[i][0], intervals[i][1]});
                index++;
            }
        }


        return res.toArray(new int[res.size()][]);
    }
}
