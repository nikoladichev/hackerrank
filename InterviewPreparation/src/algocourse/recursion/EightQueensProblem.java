package algocourse.recursion;

import java.util.*;


/**
 * Solution uses the backtracking algorithm!
 */
public class EightQueensProblem {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                    .add("x=" + x)
                    .add("y=" + y)
                    .toString();
        }
    }

    static int[][] chess = new int[][]
            {
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };

    static final Map<Point, Set<Point>> map = new HashMap<>();

    public static void main(String[] args) {
        putQueens(0);
    }

    static void putQueens(int row) {
        if (row == 8) {
            System.err.println("----------------------------");
            System.out.println("FOUND A SOLUTION");
            for (int i = 0; i < chess[0].length; i++) {
                System.out.println(Arrays.toString(chess[i]));
            }
            System.err.println("----------------------------");
        } else {
            for (int col = 0; col < 8; col++) {
                Point currentPoint = new Point(row, col);
                if (canPlaceQueen(currentPoint)) {
                    markAllAttackedPositions(currentPoint);
                    putQueens(row + 1); // put queen on next line!
                    unmarkAttackedPositions(currentPoint);
                }
            }
        }
    }

    private static void unmarkAttackedPositions(Point currentPoint) {

        System.out.println("Removing point " + currentPoint);

        chess[currentPoint.x][currentPoint.y] = 0;

        map.remove(currentPoint);

    }

    private static void markAllAttackedPositions(Point currentPoint) {

        chess[currentPoint.x][currentPoint.y] = 1;

        Set<Point> forbiddenPoints = new HashSet<>();

        // add rows
        for (int x = 0; x < 8; x++) {
            forbiddenPoints.add(new Point(x, currentPoint.y));
        }

        for (int y = 0; y < 8; y++) {
            forbiddenPoints.add(new Point(currentPoint.x, y));
        }

        // up and left
        for (int x = currentPoint.x, y = currentPoint.y; x > 0 || y > 0; x--, y--) {
            forbiddenPoints.add(new Point(x, y));
        }

        // down and left
        for (int x = currentPoint.x, y = currentPoint.y; x < 8 || y > 0; x++, y--) {
            forbiddenPoints.add(new Point(x, y));
        }

        // up and right

        for (int x = currentPoint.x, y = currentPoint.y; x > 0 || y < 8; x--, y++) {
            forbiddenPoints.add(new Point(x, y));
        }

        // down and right

        for (int x = currentPoint.x, y = currentPoint.y; x < 8 || y < 8; x++, y++) {
            forbiddenPoints.add(new Point(x, y));
        }

        // add columns
        map.put(currentPoint, forbiddenPoints);
    }



    private static boolean canPlaceQueen(Point currentPoint) {

        if (chess[currentPoint.x][currentPoint.y] == 1) return false;

        for (Set<Point> points : map.values()) {
            for (Point point : points) {
                if (point.equals(currentPoint)) {
                    return false;
                }
            }
        }

        return true;
    }
}
