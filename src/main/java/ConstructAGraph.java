import java.awt.Point;

public class ConstructAGraph {
    public static char[][] build(Point[] points) {
        int minX = 0, maxX = 0, minY = 0, maxY = 0;
        char charzero = '+';
        char charxaxis = '-';
        char charyaxis = '|';
        char charpoint = '*';
        char charnothing = ' ';

        for (Point point : points) {
            minX = Math.min(minX, point.x);
            maxX = Math.max(maxX, point.x);
            minY = Math.min(minY, point.y);
            maxY = Math.max(maxY, point.y);
        }

        int width = maxX - minX + 1;
        int height = maxY - minY + 1;

        char[][] graph = new char[height][width];

        for (int y = 0; y<height; y++) {
            for (int x = 0; x<width; x++){
                graph[y][x] = charnothing;
            }
        }

        for (int x = minX; x <= maxX; x++) {
            if (minY <= 0 && 0 <= maxY) {
                graph[maxY][x - minX] = (x == 0) ? charzero : charxaxis;
            }
        }

        for (int y = minY; y <= maxY; y++) {
            if (minX <= 0 && 0 <= maxX) {
                graph[maxY - y][0 - minX] = (y == 0) ? charzero : charyaxis;
            }
        }

        for (Point point : points) {
            int x = point.x - minX;
            int y = maxY - point.y;
            graph[y][x] = charpoint;
        }

        return graph;
    }
}
