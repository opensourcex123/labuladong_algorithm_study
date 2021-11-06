import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 752.打开转盘锁
public class openLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> deads = new HashSet<>();
        for (String d : deadends) deads.add(d);
        Set<String> visited = new HashSet<>();
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (deads.contains(cur)) continue;
                if (cur.equals(target)) return step;

                for (int j = 0; j < 4; j++) {
                    String up = doUp(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = doDown(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }

                }
            }
            step++;
        }
        return -1;
    }

    private String doUp(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j]--;
        }
        return new String(ch);
    }

    private String doDown(String cur, int j) {
        char[] ch = cur.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j]++;
        }
        return new String(ch);
    }
}
