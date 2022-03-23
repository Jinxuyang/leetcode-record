package hot100;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Verge
 * @Date 2022/3/21 23:22
 * @Version 1.0
 */
public class Code22 {
    public static void main(String[] args) {
        Code22 code22 = new Code22();
        System.out.println(code22.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        get(n,0,0,"", list);
        return list;
    }

    public void get(int n, int P, int N, String str, List<String> list) {
        if (P == n) {
            for (int i = 0; i < n - N; i++) {
                str += ")";
            }
            list.add(str);
            return;
        }

        if (P > N) {
            get(n, P + 1, N, str + "(", list);
            get(n, P, N + 1, str + ")", list);
        } else if (P == N) {
            get(n, P + 1, N, str + "(", list);
        }
    }
}
