import java.util.LinkedList;
import java.util.List;

// 797.所有可能的路径
public class allPathsSourceTarget {
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new LinkedList<>();
        if (graph.length == 0) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        path.addLast(s);

        int n = graph.length;
        if (s == n - 1) {
            res.add(new LinkedList(path));
            path.removeLast();
            return;
        }

        for (int v : graph[s]) {
            traverse(graph, v, path);
        }

        path.removeLast();
    }
}
