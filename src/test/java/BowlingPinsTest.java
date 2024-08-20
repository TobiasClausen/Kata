import BowlingPins.BowlingPins;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingPinsTest {
    @Test
    public void exampleTests()
    {
        BowlingPins bowling = new BowlingPins();
        int[] testArray = new int[]{1,2,3};
        assertEquals("I I I I\n I I I \n       \n       ", bowling.bowling(testArray));

        testArray = new int[]{3,5,9};
        assertEquals("I I   I\n I   I \n  I    \n   I   ", bowling.bowling(testArray));
    }
}
