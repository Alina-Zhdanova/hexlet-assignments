package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
@Getter
@AllArgsConstructor
public class Circle {
    private final Point point;
    private final int radius;

    public double getSquare() throws NegativeRadiusException {
        if (getRadius() < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return Math.PI * (getRadius() * getRadius());
    }
}
// END
