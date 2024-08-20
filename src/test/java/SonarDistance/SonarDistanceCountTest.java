package SonarDistance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SonarDistanceCountTest {

    @Test
    void getCountOfIncreasments(){
        SonarDistanceCount testee = new SonarDistanceCount();
        int[] input = {10, 20, 30, 40, 30, 30};
        int expected = 3;

        int actual = testee.getCountOfIncreasments(input);

        assertEquals(expected, actual);
    }
}