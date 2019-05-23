package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlaneFigureTest {
    @Test
    void 중복되는_좌표를_입력한_경우_예외_발생() {
        Coordinate c1 = new Coordinate(10, 10);
        Coordinate c2 = new Coordinate(10, 20);
        Coordinate c3 = new Coordinate(10, 10);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3);

        assertThrows(IllegalArgumentException.class, () -> new PlaneFigure(coordinates) {
            @Override
            public double calculateArea() {
                return 0;
            }
        });
    }

    @Test
    void 중복되지_않는_좌표를_입력한_경우() {
        Coordinate c1 = new Coordinate(10, 10);
        Coordinate c2 = new Coordinate(10, 20);
        Coordinate c3 = new Coordinate(11, 10);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3);

        assertDoesNotThrow(() -> new PlaneFigure(coordinates) {
            @Override
            public double calculateArea() {
                return 0;
            }
        });
    }

    @Test
    void 한_직선_위에_있는_세_좌표를_입력한_경우_예외_발생() {
        Coordinate c1 = new Coordinate(5, 5);
        Coordinate c2 = new Coordinate(10, 10);
        Coordinate c3 = new Coordinate(15, 15);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3);

        assertThrows(IllegalArgumentException.class, () -> new PlaneFigure(coordinates) {
            @Override
            public double calculateArea() {
                return 0;
            }
        });
    }

    @Test
    void 한_직선_위에_있지_않은_세_좌표를_입력한_경우() {
        Coordinate c1 = new Coordinate(5, 5);
        Coordinate c2 = new Coordinate(10, 10);
        Coordinate c3 = new Coordinate(15, 16);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3);

        assertDoesNotThrow(() -> new PlaneFigure(coordinates) {
            @Override
            public double calculateArea() {
                return 0;
            }
        });
    }
}
