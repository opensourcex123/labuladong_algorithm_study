// 921.使括号有效的最小添加
public class minAddToMakeValid {
    public int minAddToMakeValid(String s) {
        int res = 0;
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                need++;
            }

            if (c == ')') {
                need--;
            }

            if (need == -1) {
                need = 0;
                res++;
            }
        }

        return need + res;
    }
}
