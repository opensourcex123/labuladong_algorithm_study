import java.util.Stack;

// 224.基本计算器
public class calculate {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }

            if (c == '(') {
                num = calculate(s.substring(i + 1));
                i = move(s, i);
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stk.push(num);
                        break;
                    case '-':
                        stk.push(-num);
                        break;
                }
                sign = c;
                num = 0;
            }

            if (c == ')') break;
        }

        int res = 0;
        while (!stk.isEmpty()) {
            res += stk.peek();
            stk.pop();
        }
        return res;
    }

    private int move(String s, int i) {
        int left = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') left++;
            if (s.charAt(i) == ')') left--;
            if (left == 0) return i;
            i++;
        }
        return i;
    }
}