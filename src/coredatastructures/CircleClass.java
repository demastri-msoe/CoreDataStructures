package coredatastructures;

public class CircleClass {
    public double radius;
    public double xLocation;
    public double yLocation;

    public CircleClass(double radius, double xLocation, double yLocation) {
        this.radius = radius;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public void display() {
        // take the action to print this to the display
        // probably uses both the location and radius parameters
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public String getName() {
        return "Circle";
    }

}
