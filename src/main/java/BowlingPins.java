public class BowlingPins {
    public String bowling(int[] arr){
        String styledresult;
        char[][] result = new char[4][7];
        for (int i = 0; i<result.length; i++){
            for (int j = 0; j<result[i].length; j++){
                result[i][j]=' ';
            }
        }
        int[][] position = {
                {3, 3},
                {2, 2},
                {2, 4},
                {1, 1},
                {1, 3},
                {1, 5},
                {0, 0},
                {0, 2},
                {0, 4},
                {0, 6}
        };

        for (int i=0; i<10; i++) {
            int row = position[i][0];
            int column = position[i][1];
            result[row][column]='I';
        }

        for (int i: arr){
            if (i>=1&&i <= 10){
                int row=position[i-1][0];
                int column=position[i-1][1];
                result[row][column]=' ';
            }
        }


        System.out.println(result);

        return styledresult = styleResultArray(result);
    }
    private String styleResultArray(char[][] result){
        StringBuilder stringBuilder = new StringBuilder();
        String styledResult;
        for (int i = 0; i<result.length; i++){
            for (int j = 0; j<result[i].length; j++){
                 stringBuilder.append(result[i][j]);
            }
            if (i<result.length-1){
                stringBuilder.append("\n");
            }

        }
        return styledResult=stringBuilder.toString();
    }
}
