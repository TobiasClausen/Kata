package SonarDistance;

public class SonarDistenceCountedByGroup {

    public int getCountsOnIncreamentsGrouped(int[] sonarReport){
        SonarDistanceCount sonarDistanceCount = new SonarDistanceCount();
        int[] threeMeasurement = mapToGroup(sonarReport);
        return sonarDistanceCount.getCountOfIncreasments(threeMeasurement);
    }

    int[] mapToGroup(int[] sonarReport){
        int[] sonarReportGrouped = new int[sonarReport.length-2];
        for (int i = 0; i < sonarReportGrouped.length;i++){
            sonarReportGrouped[i] = getSum(sonarReport[i], sonarReport[i+1], sonarReport[i+2]);
        }
        return sonarReportGrouped;
    }

    private int getSum(int sum1, int sum2, int sum3) {
        return sum1 + sum2 + sum3;
    }
}
