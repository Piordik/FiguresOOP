package main.figures;

import main.Point;

import java.util.ArrayList;

import static main.consts.Consts.*;

public class Sphere extends Figure {
    private final ArrayList<Point> points;

    private Point center;

    private Point pointOnSurface;

    public Sphere(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean validateFigure() {
        if (points.size() != TWO_POINTS) {
            return false;
        }

        getPoints();
        double radiusSquared = calculateLength(pointOnSurface, center);
        return radiusSquared > 0;
    }

    @Override
    public double calculateArea() {
        getPoints();
        double radius = calculateLength(pointOnSurface, center);
        return  4 * Math.PI * Math.pow(radius, 2);
    }

    private void getPoints() {
        center = points.get(FIRST_POINT_INDEX);
        pointOnSurface = points.get(SECOND_POINT_INDEX);
    }
}
