package array;

public class JZOffer05 {
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public String replaceSpace1(String s) {
        return s.replace(" ", "%20");
    }


}
