package SonarDistance;

public class SonarDistanceCount {
    int previous;
    public int getCountOfIncreasments(int[] sonarReport){
        int countSonarIncreasment=0;

        previous = sonarReport[0];

        for (int i=1; i < sonarReport.length; i++){
            countSonarIncreasment = sonarIncrasment(sonarReport[i], countSonarIncreasment);
        }
        return countSonarIncreasment;
    }
    private int sonarIncrasment(int distanceToKey, int countSonarIncreasment){
        if (distanceToKey>previous){
            countSonarIncreasment++;
        }
        previous = distanceToKey;
        return countSonarIncreasment;
    };
}
