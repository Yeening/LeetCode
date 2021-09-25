import java.util.*;

// Treat each point as a bottom right corner point to find possible squares

public class Squares {
    static class Point implements Comparable<Point>{
        public int x;
        public int y;
        public Point left = null;
        public Point up = null;
        public Map<Integer, Point> YToLeftPoints = new HashMap<>();
        public Map<Integer, Point> XToUpPoints = new HashMap<>();

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, Point left, Point up) {
            this.x = x;
            this.y = y;
            this.left = left;
            this.up = up;
        }

        @Override
        public int compareTo(Point point) {
            return (x == point.x)? Integer.compare(y, point.y): Integer.compare(x, point.x);
        }
    }

    public static int findSquares(Point[] points) {
        if (points == null || points.length < 4) return 0;
        Arrays.sort(points);
        int squares = 0;

        for (Point point: points) {
            if (point.left != null) {
                point.YToLeftPoints = point.left.YToLeftPoints;
                point.YToLeftPoints.put(point.left.y, point.left);
            }
            if (point.up != null) {
                point.XToUpPoints = point.up.XToUpPoints;
                point.XToUpPoints.put(point.up.x, point.up);
            }
            squares += countSquares(point);
        }
        return squares;
    }

    private static int countSquares(Point bottomRightPoint) {
        Map<Integer, Point> YToLeftPoints = bottomRightPoint.YToLeftPoints;
        Map<Integer, Point> XToUpPoints = bottomRightPoint.XToUpPoints;
        int squares = 0;

        for (int x: XToUpPoints.keySet()) {
            int y =  bottomRightPoint.y + x - bottomRightPoint.x;
            if (YToLeftPoints.containsKey(y)) {
                Point leftPoint = YToLeftPoints.get(y), upPoint = XToUpPoints.get(x);
                boolean isSquare = upPoint.YToLeftPoints.containsKey(y) && leftPoint.XToUpPoints.containsKey(x);
                if (isSquare) {squares++;}
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        Point[] points = new Point[15];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 1, points[0], null);
        points[6] = new Point(0, 2, points[1], null);
        points[7] = new Point(0, 3, points[6], null);
        points[8] = new Point(0, 4, points[7], null);
        points[2] = new Point(1, 0, null, points[1]);
        points[3] = new Point(1, 1, points[2], points[1]);
        points[9] = new Point(1, 2, points[3], points[6]);
        points[10] = new Point(1, 3, points[9], null);
        points[11] = new Point(1, 4, points[10], null);
        points[4] = new Point(2, 0, null, points[2]);
        points[5] = new Point(2, 1, points[4], points[3]);
        points[12] = new Point(2, 2, points[5], points[9]);
        points[13] = new Point(2, 3, points[12], null);
        points[14] = new Point(2, 4, points[13], null);

        System.out.println(findSquares(points));
    }

}
