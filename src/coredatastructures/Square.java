package coredatastructures;

import java.awt.geom.Point2D;

public class Square  implements Shape{
    private double sideLength;
    private Point2D location;

    public Square(double sideLength, Point2D location) {
        this.sideLength = sideLength;
        this.location = location;
    }


    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public void display() {
        // take the action to print this to the display
        // probably uses both the location and radius parameters
    }

    @Override
    public String name() {
        return "Square";
    }
}
