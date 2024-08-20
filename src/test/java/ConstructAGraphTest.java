import Graphdimensions.ConstructAGraph;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.awt.Point;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TODO: Replace examples and use TDD by writing your own tests

public class ConstructAGraphTest {
    @Test
    void testSample() {
        test(new Point[] { new Point(1, 1), new Point(3, 2) }, new char[][] { { '|', ' ', ' ', '*' }, { '|', '*', ' ', ' ' }, { '+', '-', '-', '-' } });
        test(new Point[] { new Point(-1, 1), new Point(-3, 2) }, new char[][] { { '*', ' ', ' ', '|' }, { ' ', ' ', '*', '|' }, { '-', '-', '-', '+' } });
        test(new Point[] { new Point(1, 1), new Point(2, 3) }, new char[][] { { '|', ' ', '*' }, { '|', ' ', ' ' }, { '|', '*', ' ' }, { '+', '-', '-' } });
        test(new Point[] { new Point(-1, -1), new Point(-2, -3) }, new char[][] { { '-', '-', '+' }, { ' ', '*', '|' }, { ' ', ' ', '|' }, { '*', ' ', '|' } });
        test(new Point[] {}, new char[][] { { '+' } });
        test(new Point[] { new Point(0, 0) }, new char[][] { { '*' } });
    }

    private String format(char[][] g) {
        return Stream.of(g).map(gs -> "[" + String.valueOf(gs) + "]").collect(Collectors.joining("\n"));
    }

    private void test(Point[] input, char[][] expected) {
        StringBuilder sb = new StringBuilder("{");
        for (var p : input) {
            sb.append(String.format("{x: %d, y: %d}", p.x, p.y)).append(",");
        }
        sb.append("}");
        String strPoints = sb.toString().replace("},}", "}}");
        char[][] actual = ConstructAGraph.build(input);
        String msg = String.format("Test failed for points %s\n\nActual:\n%s\n\nExpected:\n%s\n",
                strPoints, format(actual), format(expected));
        assertArrayEquals(actual, expected, msg);
    }

}
