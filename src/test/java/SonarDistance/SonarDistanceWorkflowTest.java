package SonarDistance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SonarDistanceWorkflowTest {
    @Test
    void getDistanceCountWithInput() {
        SonarDistanceWorkflow testee = new SonarDistanceWorkflow();

        int actualCount = testee.getDistanceCountWithInput();

        assertTrue(actualCount >= 0);
    }

    @Test
    void getDistenceCountedByGroup() {
        SonarDistanceWorkflow testee = new SonarDistanceWorkflow();

        int actualCount = testee.getDistenceCountedByGroup();

        assertTrue(actualCount >= 0);
    }
}