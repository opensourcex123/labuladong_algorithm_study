// 1541.平衡括号字符串的最少插入次数
public class minInsertionsII {
    public int minInsertions(String s) {
        int res = 0;
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                need += 2;
                if (need % 2 != 0) {
                    // 右括号加一
                    res++;
                    need--;
                }
            } else if (c == ')') {
                need--;
                if (need == -1) {
                    //左括号加一
                    res++;
                    need = 1;
                }
            }
        }

        return res + need;
    }
}
