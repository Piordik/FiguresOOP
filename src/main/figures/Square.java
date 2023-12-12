package main.figures;

import main.Point;

import java.util.ArrayList;

import static main.consts.Consts.*;

public class Square extends Figure {
    private final ArrayList<Point> points;

    private double sideAB;

    private double sideBC;

    private double sideCD;

    private double sideAD;

    private Point pointA;

    private Point pointB;

    private Point pointC;

    private Point pointD;

    public Square(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean validateFigure() {
        if (points.size() == FOUR_POINTS) {
            getPoints();
            calculateSides();
            return areSidesEqual() && areAllAnglesEqual(pointA, pointB, pointC, pointD);
        }
        return false;
    }

    @Override
    public double calculateArea() {
        getPoints();
        calculateSides();
        return Math.pow(sideAB, 2);
    }

    @Override
    public double calculatePerimeter() {
        getPoints();
        calculateSides();
        return sideAB * FOUR_POINTS;
    }

    private boolean areSidesEqual() {
        return sideAB == sideBC && sideCD == sideAD && sideAB == sideCD;
    }

    private void calculateSides() {
        sideAB = calculateLength(pointA, pointB);
        sideBC = calculateLength(pointB, pointC);
        sideCD = calculateLength(pointC, pointD);
        sideAD = calculateLength(pointA, pointD);
    }

    private void getPoints() {
        pointA = points.get(FIRST_POINT_INDEX);
        pointB = points.get(SECOND_POINT_INDEX);
        pointC = points.get(THIRD_POINT_INDEX);
        pointD = points.get(FOURTH_POINT_INDEX);
    }
}
