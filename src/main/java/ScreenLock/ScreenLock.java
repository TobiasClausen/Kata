package ScreenLock;

import java.util.*;
public class ScreenLock {
    // Skip array to store invalid intermediate points
    private static int[][] skip;

    public ScreenLock() {

        skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
    }

    public int calculateCombinations(char startPosition, int patternLength) {
        if (patternLength == 0) return 0;

        boolean[] visited = new boolean[10];
        int start = startPosition - 'A' + 1;
        return dfs(start, patternLength - 1, visited);
    }

    private int dfs(int current, int remainingLength, boolean[] visited) {
        if (remainingLength == 0) return 1;

        visited[current] = true;
        int totalPatterns = 0;

        for (int next = 1; next <= 9; next++) {
            if (!visited[next] && (skip[current][next] == 0 || visited[skip[current][next]])) {
                totalPatterns += dfs(next, remainingLength - 1, visited);
            }
        }

        visited[current] = false;

        return totalPatterns;
    }
}
