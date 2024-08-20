package SonarDistance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SonarDistanceTest {
    @Test
    void getDistanceCountWithInput(){
        SonarDistance testee = new SonarDistance();

        int actual = testee.getDistanceCountWithInput();

        Assertions.assertNotNull(actual);
    }
}