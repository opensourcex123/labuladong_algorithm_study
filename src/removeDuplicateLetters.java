import java.util.Stack;

// 316.去除重复字母
public class removeDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[256];
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        boolean[] inStack = new boolean[256];
        for (char c: s.toCharArray()) {
            count[c]--;
            if (inStack[c]) continue;
            while (!stk.isEmpty() && stk.peek() > c) {
                if (count[stk.peek()] == 0) break;
                inStack[stk.pop()] = false;
            }
            stk.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
