package SonarDistance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SonarDistanceIntegrationTest {
    @Test
    void SonarDistanceCountWithDAONumbers(){
        DAONumbers daoNumbers = new DAONumbers();
        SonarDistanceCount sonarDistance = new SonarDistanceCount();
        int expectedIncreasments = 1832;

        int[] input = daoNumbers.getNumbers("/Users/tobiasclausen/Documents/CSS/2024/Projekte/Kata/src/main/resources/SonarDistance/Sonardistance.txt");
        int actualIncreasment = sonarDistance.getCountOfIncreasments(input);

        assertEquals(expectedIncreasments, actualIncreasment);
    }

    @Test
    void SonarDistenceCountedByGroup(){
        DAONumbers daoNumbers = new DAONumbers();
        SonarDistenceCountedByGroup sonarDistenceCountedByGroup = new SonarDistenceCountedByGroup();
        int expectedIncreasments = 1858;

        int[] input = daoNumbers.getNumbers("/Users/tobiasclausen/Documents/CSS/2024/Projekte/Kata/src/main/resources/SonarDistance/Sonardistance.txt");
        int actualIncreaments = sonarDistenceCountedByGroup.getCountsOnIncreamentsGrouped(input);

        assertEquals(expectedIncreasments, actualIncreaments);
    }
}
