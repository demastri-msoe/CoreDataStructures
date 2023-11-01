package coredatastructures;

import java.awt.geom.Point2D;

public class Circle implements Shape{
    private double radius;
    private Point2D location;

    public Circle(double radius, Point2D location) {
        this.radius = radius;
        this.location = location;
    }


    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        // take the action to print this to the display
        // probably uses both the location and radius parameters
    }

    @Override
    public String name() {
        return "Circle";
    }
}
