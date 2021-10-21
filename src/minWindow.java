import java.util.HashMap;
import java.util.Map;

// 76.覆盖最小字串 滑动窗口
public class minWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int valid = 0;
        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            //debug输出位置
             System.out.println("window: [" + left + ", " + right + "]");
            /****************** */

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                    end = start + len;
                }
                char d = s.charAt(left);
                left++;
                // 数据更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}

class Main {
    public static void main(String[] args) {
        String s ="ADOBECODEBANC";
        String t = "ABC";
        minWindow minWindow = new minWindow();
        minWindow.minWindow(s, t);
    }
}
