import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 773.滑动谜题
public class slidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        String start = convertToString(board);
        String target = "123450";
        System.out.println(start);
        int[][] neighbor = new int[][]{
                { 1, 3 },
                { 0, 4, 2 },
                { 1, 5 },
                { 0, 4 },
                { 3, 1, 5 },
                { 4, 2 }
        };
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);
        int step = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                assert cur != null;
                char[] ch = cur.toCharArray();
                if (cur.equals(target)) return step;

                int idx = 0;
                for (; ch[idx] != '0'; idx++);
                for (int j = 0; j < neighbor[idx].length; j++) {
                    int adj = neighbor[idx][j];
                    String new_board = cur;
                    new_board = swap(new_board, adj, idx);
                    if (!visited.contains(new_board)) {
                        q.offer(new_board);
                        visited.add(new_board);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String convertToString(int[][] array) {
        StringBuilder str = new StringBuilder();
        String tempStr = null;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                tempStr = String.valueOf(array[i][j]);
                str.append(tempStr);
            }
        }
        return str.toString();
    }

    private String swap(String s, int a, int b) {
        StringBuilder sb = new StringBuilder(s);
        char temp = sb.charAt(a);
        sb.setCharAt(a,sb.charAt(b));
        sb.setCharAt(b,temp);
        return sb.toString();
    }
}