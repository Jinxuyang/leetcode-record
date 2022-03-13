package other;

/**
 * @Author Verge
 * @Date 2022/2/23 19:33
 * @Version 1.0
 */
public class JZOffer43 {
    public int countDigitOne(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += countOne(i);
        }
        
        return cnt;
    }

    int countOne(int n){
        String s = String.valueOf(n);
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1'){
                cnt++;
            }
        }
        return cnt;
    }
}
