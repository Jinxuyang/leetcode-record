package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Verge
 * @Date 2022/3/27 20:23
 * @Version 1.0
 */
public class Code49 {
    public static void main(String[] args) {
        Code49 code49 = new Code49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(code49.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = Arrays.toString(cs);
            List<String> list;
            if (res.containsKey(key)) {
                list = res.get(key);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            res.put(key, list);
        }

        List<List<String>> list = new ArrayList<>();
        res.keySet().forEach(key-> list.add(res.get(key)));
        return list;
    }
}
