package SonarDistance;

public class SonarDistanceCount {
    public int getCountOfIncreasments(int[] sonarReport){
        int countSonarIncreasment = 0;
        int previous = sonarReport[0];

        for (int i = 1; i < sonarReport.length; i++){
            countSonarIncreasment = sonarIncrasment(sonarReport[i], countSonarIncreasment, previous);
            previous = sonarReport[i];
        }
        return countSonarIncreasment;
    }
    private int sonarIncrasment(int distanceToKey, int countSonarIncreasment, int previous){
        if (distanceToKey>previous){
            countSonarIncreasment++;
        }
        return countSonarIncreasment;
    };
}
