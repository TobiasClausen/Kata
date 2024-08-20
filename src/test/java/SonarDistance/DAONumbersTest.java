package SonarDistance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DAONumbersTest {
    @Test
    void getNumbers(){
        DAONumbers testee = new DAONumbers();

        int[] actual = testee.getNumbers("/Users/tobiasclausen/Documents/CSS/2024/Projekte/Kata/src/main/resources/SonarDistance/Sonardistance.txt");

        for (int distance : actual){
            System.out.println(distance);
        }
        assertNotNull(actual);
    }
}