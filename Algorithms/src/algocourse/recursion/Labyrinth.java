package algocourse.recursion;

import java.util.*;

public class Labyrinth {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
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


    static char[][] labyrinth = new char[][] {
            {'-', '-', '-', '*', '-', '-', '-'},
            {'*', '*', '-', '*', '-', '*', '-'},
            {'-', '-', '-', '-', '-', '-', '-'},
            {'-', '*', '*', '*', '*', '*', '-'},
            {'-', '-', '-', '-', '-', '-', 'e'}
    };

    static final Set<Point> visitedPoints = new HashSet<>();

    static void findPath(Point currentPoint) {

        if (isOutOfBounds(currentPoint)) return;

        if (labyrinth[currentPoint.x][currentPoint.y] == 'e') {
            System.err.println("----------------------------");
            System.out.println("FOUND A SOLUTION");
            char[][] finished = Arrays.stream(labyrinth).map(char[]::clone).toArray(char[][]::new);
            for (Point p: visitedPoints) {
                finished[p.x][p.y] = 'X';
            }
            for (char[] chars : finished) {
                System.out.println(Arrays.toString(chars));
            }
            System.err.println("----------------------------");
        } else if (!isVisited(currentPoint) && isPassable(currentPoint)) {

            visitedPoints.add(currentPoint); // mark point

            findPath(new Point(currentPoint.x - 1, currentPoint.y)); // up
            findPath(new Point(currentPoint.x + 1, currentPoint.y)); // down

            findPath(new Point(currentPoint.x, currentPoint.y - 1)); // left
            findPath(new Point(currentPoint.x, currentPoint.y + 1)); // right

            visitedPoints.remove(currentPoint); // unmark point
        }

    }

    private static boolean isPassable(Point currentPoint) {
        return labyrinth[currentPoint.x][currentPoint.y] == '-';
    }

    static boolean isVisited(Point currentPoint) {
        for (Point point: visitedPoints) {
            if (point.equals(currentPoint)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOutOfBounds(Point currentPoint) {
        return currentPoint.x < 0 || currentPoint.y < 0 || currentPoint.x >= labyrinth.length || currentPoint.y >= labyrinth[0].length;
    }

    public static void main(String[] args) {
        findPath(new Point(0, 0));
    }
}
