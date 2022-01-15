import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 391.完美矩形,java版本会超时，见python版本
public class isRectangleCover {
    public boolean isRectangleCover(int[][] rectangles) {
        int X1 = Integer.MAX_VALUE;
        int Y1 = Integer.MAX_VALUE;
        int X2 = Integer.MIN_VALUE;
        int Y2 = Integer.MIN_VALUE;

        int actualArea = 0;
        int expectedArea = 0;

        List<List<Integer>> points = new LinkedList<>();

        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0];
            int y1 = rectangle[1];
            int x2 = rectangle[2];
            int y2 = rectangle[3];

            actualArea += (x2 - x1) * (y2 - y1);
            X1 = Math.min(x1, X1);
            Y1 = Math.min(y1, Y1);
            X2 = Math.max(x2, X2);
            Y2 = Math.max(y2, Y2);

            List<Integer> p1 = Arrays.asList(x1, y1);
            List<Integer> p2 = Arrays.asList(x1, y2);
            List<Integer> p3 = Arrays.asList(x2, y1);
            List<Integer> p4 = Arrays.asList(x2, y2);

            if (points.contains(p1)) points.remove(p1);
            else points.add(p1);
            if (points.contains(p2)) points.remove(p2);
            else points.add(p2);
            if (points.contains(p3)) points.remove(p3);
            else points.add(p3);
            if (points.contains(p4)) points.remove(p4);
            else points.add(p4);
        }

        expectedArea = (X2 - X1) * (Y2 - Y1);
        if (expectedArea != actualArea) return false;
        if (points.size() != 4) return false;

        List<Integer> p1 = Arrays.asList(X1, Y1);
        List<Integer> p2 = Arrays.asList(X1, Y2);
        List<Integer> p3 = Arrays.asList(X2, Y1);
        List<Integer> p4 = Arrays.asList(X2, Y2);
        if (!points.contains(p1)) return false;
        if (!points.contains(p2)) return false;
        if (!points.contains(p3)) return false;
        if (!points.contains(p4)) return false;

        return true;
    }
}
