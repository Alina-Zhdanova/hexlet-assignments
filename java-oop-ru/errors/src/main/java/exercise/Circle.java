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
        return Math.sqrt(Math.PI * getRadius());
    }
}
// END
