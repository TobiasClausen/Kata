package SonarDistance;

public class SonarDistanceWorkflow {
    public int getDistanceCountWithInput() {
        DAONumbers daoNumbers = new DAONumbers();
        SonarDistanceCount sonarDistance = new SonarDistanceCount();

        int[] input = daoNumbers.getNumbers("/Users/tobiasclausen/Documents/CSS/2024/Projekte/Kata/src/main/resources/SonarDistance/Sonardistance.txt");

        return sonarDistance.getCountOfIncreasments(input);
    }

    public int getDistenceCountedByGroup() {
        DAONumbers daoNumbers = new DAONumbers();
        SonarDistenceCountedByGroup sonarDistenceCountedByGroup = new SonarDistenceCountedByGroup();

        int[] input = daoNumbers.getNumbers("/Users/tobiasclausen/Documents/CSS/2024/Projekte/Kata/src/main/resources/SonarDistance/Sonardistance.txt");
        return sonarDistenceCountedByGroup.getCountsOnIncreamentsGrouped(input);
    }
}
