import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class SimpleSumOfPairsTest {
    @Test
    public void basictest(){
        SimpleSumOfPairs simpleSumOfPairs = new SimpleSumOfPairs();
        assertEquals(0,simpleSumOfPairs.solve(0));
        assertEquals(1,simpleSumOfPairs.solve(1));
        assertEquals(18,simpleSumOfPairs.solve(18));
        assertEquals(11,simpleSumOfPairs.solve(29));
        assertEquals(33,simpleSumOfPairs.solve(1140));
        assertEquals(68,simpleSumOfPairs.solve(50000000));
    }
}
