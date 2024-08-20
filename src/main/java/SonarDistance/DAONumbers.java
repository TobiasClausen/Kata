package SonarDistance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DAONumbers {
    public int[] getNumbers(String path){
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\n+");
                for (String token : tokens) {
                    numbers.add(Integer.parseInt(token));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numbers.stream().mapToInt(i -> i).toArray();
    }
}
