package SonarDistance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SonarDistanceCountTest {

    @Test
    void getCountOfIncreasments(){
        SonarDistanceCount testee = new SonarDistanceCount();
        int[] input = {10, 20, 30, 40, 30};
        int expected = 3;

        int actual = testee.getCountOfIncreasments(input);

        Assertions.assertEquals(expected, actual);
    }
}