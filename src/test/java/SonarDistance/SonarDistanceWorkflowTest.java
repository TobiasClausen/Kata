package SonarDistance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SonarDistanceWorkflowTest {
    @Test
    void getDistanceCountWithInput(){
        SonarDistanceWorkflow testee = new SonarDistanceWorkflow();

        int actual = testee.getDistanceCountWithInput();

        Assertions.assertNotNull(actual);
    }
}