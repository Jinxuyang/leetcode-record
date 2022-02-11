package tree;

import java.util.*;

/**
 * @Author Verge
 * @Date 2022/2/11 9:04
 * @Version 1.0
 */
public class JZOffer38 {
    public static void main(String[] args) {
        JZOffer38 jzOffer38 = new JZOffer38();
        jzOffer38.permutation("abc");
    }

    Set<String> resList = new HashSet<>();
    public String[] permutation(String s) {
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        recur("", list);

        return resList.toArray(new String[0]);
    }

    public void recur(String builder, List<Character> chars) {
        for (int i = 0; i < chars.size(); i++) {
            char temp = chars.get(i);
            List<Character> tempChars = new LinkedList<>(chars);
            tempChars.remove(i);
            recur(builder + temp, tempChars);
        }
        if (chars.size() == 0) {
            resList.add(builder);
        }

    }
}
