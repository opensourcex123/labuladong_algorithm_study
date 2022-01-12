import java.util.Stack;

// 20.有效的括号
public class isValid {
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                left.push(c);
            } else {
                if (!left.isEmpty() && leftOf(c) == left.peek()) {
                    left.pop();
                } else {
                    return false;
                }
            }
        }

        return left.isEmpty();
    }

    private char leftOf(char c) {
        if (c == ')') return '(';
        if (c == ']') return '[';
        return '{';
    }
}
