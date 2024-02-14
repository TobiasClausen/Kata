


public class Collinearity {
    public static boolean collinearity(int x1, int y1, int x2, int y2) {
        int result = x1 * y2 - x2 * y1;

        return result == 0;
    }
}



