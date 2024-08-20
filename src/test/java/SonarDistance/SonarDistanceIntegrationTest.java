package SonarDistance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SonarDistanceIntegrationTest {
    @Test
    void SonarDistanceCountWithDAONumbers(){
        DAONumbers daoNumbers = new DAONumbers();
        SonarDistanceCount sonarDistance = new SonarDistanceCount();

        int[] input = daoNumbers.getNumbers("/Users/tobiasclausen/Documents/CSS/2024/Projekte/Kata/src/main/resources/SonarDistance/Sonardistance.txt");

        Assertions.assertNotNull(sonarDistance.getCountOfIncreasments(input));
    }
}
