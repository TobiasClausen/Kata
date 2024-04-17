import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareableTest {
    @Test
    public void basicTests() {
        assertEquals(Squareable.countSquareable(4), 3);
        assertEquals(Squareable.countSquareable(5), 4);
        assertEquals(Squareable.countSquareable(40), 30);
        assertEquals(Squareable.countSquareable(20), 15);
        assertEquals(Squareable.countSquareable(10), 7);
        assertEquals(Squareable.countSquareable(50), 37);
    }
}
