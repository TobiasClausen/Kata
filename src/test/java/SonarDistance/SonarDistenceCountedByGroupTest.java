package SonarDistance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SonarDistenceCountedByGroupTest {

    SonarDistenceCountedByGroup testee = new SonarDistenceCountedByGroup();
    @Test
    void mapToMedian(){
        int[] sonarReport = {199, 200, 208, 210, 200, 207, 240, 269, 260, 263};

        int[] actualGroup = testee.mapToMedian(sonarReport);

        assertEquals(actualGroup[0], 607);
    }

    @Test
    void getCountsOnIncreamentsGrouped(){
        int[] sonarReport = {199, 200, 208, 210, 200, 207, 240, 269, 260, 263};
        int expectedCount = 5;

        int actualCount = testee.getCountsOnIncreamentsGrouped(sonarReport);

        assertEquals(expectedCount, actualCount);

    }
}