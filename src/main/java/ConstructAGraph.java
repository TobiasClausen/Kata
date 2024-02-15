import java.awt.Point;

public class ConstructAGraph {

    public static final char CHARZERO = '+';
    public static final char CHARYAXIS = '|';
    public static final char CHARXAXIS = '-';
    public static final char CHARPOINT = '*';
    public static final char CHARNOTHING = ' ';

    public static char[][] build(Point[] points) {
        Graphdimensions graphdimensions = new Graphdimensions(points);


        int width = graphdimensions.getMaxX() - graphdimensions.getMinX() + 1;
        int height = graphdimensions.getMaxY() - graphdimensions.getMinY() + 1;

        char[][] graph = new char[height][width];

        fillUpWholearray(width, height, graph);

        drawXAxis(graphdimensions, graph);
        drawYAxis(graphdimensions, graph);
        fillGraphWithPoints(points, graphdimensions, graph);

        return graph;
    }

    private static void fillUpWholearray(int width, int height, char[][] graph) {
        for (int y = 0; y< height; y++) {
            for (int x = 0; x< width; x++){
                graph[y][x] = CHARNOTHING;
            }
        }
    }

    private static void drawXAxis(Graphdimensions graphdimensions, char[][] graph) {
        for (int x = graphdimensions.getMinX(); x <= graphdimensions.getMaxX(); x++) {
            if (graphdimensions.getMinY() <= 0 && 0 <= graphdimensions.getMaxY()) {
                graph[graphdimensions.getMaxY()][x - graphdimensions.getMinX()] = (x == 0) ? CHARZERO : CHARXAXIS;
            }
        }
    }

    private static void drawYAxis(Graphdimensions graphdimensions, char[][] graph) {
        for (int y = graphdimensions.getMinY(); y <= graphdimensions.getMaxY(); y++) {
            if (graphdimensions.getMinX() <= 0 && 0 <= graphdimensions.getMaxX()) {
                graph[graphdimensions.getMaxY() - y][0 - graphdimensions.getMinX()] = (y == 0) ? CHARZERO : CHARYAXIS;
            }
        }
    }


    private static void fillGraphWithPoints(Point[] points, Graphdimensions graphdimensions, char[][] graph) {
        for (Point point : points) {
            int x = point.x - graphdimensions.getMinX();
            int y = graphdimensions.getMaxY() - point.y;
            graph[y][x] = CHARPOINT;
        }
    }
}