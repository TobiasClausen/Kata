package Graphdimensions;

import java.awt.*;

public class Graphdimensions {
    private Point[] points;
    private int minX= 0;
    private int maxX = 0;
    private int minY = 0;
    private int maxY = 0;


    public Graphdimensions(Point[] points) {

        this.points = points;

        for (Point point : points) {
            minX = Math.min(minX, point.x);
            maxX = Math.max(maxX, point.x);
            minY = Math.min(minY, point.y);
            maxY = Math.max(maxY, point.y);
        }
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }
}



