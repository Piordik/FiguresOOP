package main.tests;

import main.Point;
import main.figures.Rectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;

public class RectangleT {

    ArrayList<Point> points = new ArrayList<>();

    @Test
    @DisplayName("Rectangle area and perimeter methods")
    public void RectangleAreaAndPerimeterMethods() {
        addPointsForValidTest();
        Rectangle rectangle = new Rectangle(points);

        then(rectangle.round(rectangle.calculateArea())).isEqualTo(6);
        then(rectangle.round(rectangle.calculatePerimeter())).isEqualTo(10);

    }

    @Test
    @DisplayName("Rectangle validation method")
    public void RectangleValidationMethod() {
        addPointsForValidTest();
        Rectangle rectangle = new Rectangle(points);
        then(rectangle.validateFigure()).isTrue();

        addPointsForInvalidTest();
        rectangle = new Rectangle(points);
        then(rectangle.validateFigure()).isFalse();
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 0));
        points.add(new Point(3, 0));
        points.add(new Point(3, 2));
        points.add(new Point(0, 2));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(1, 0));
        points.add(new Point(5, 0));
        points.add(new Point(5, 3));
        points.add(new Point(1, 2));
    }
}