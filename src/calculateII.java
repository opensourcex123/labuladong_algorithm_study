import java.util.Stack;

// 227.基本计算器II
public class calculateII {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                int pre = 0;
                switch (sign) {
                    case '+':
                        stk.push(num);
                        break;
                    case '-':
                        stk.push(-num);
                        break;
                    case '*':
                        pre = stk.peek();
                        stk.pop();
                        stk.push(num * pre);
                        break;
                    case '/':
                        pre = stk.peek();
                        stk.pop();
                        stk.push(pre / num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }

        int res = 0;
        while (!stk.isEmpty()) {
            res += stk.peek();
            stk.pop();
        }

        return res;
    }
}
