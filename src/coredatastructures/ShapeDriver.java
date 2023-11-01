package coredatastructures;

import java.awt.geom.Point2D;

public class ShapeDriver {

    public static void main(String[] args) {
        CircleClass c1 = new CircleClass( 1.0, 2.0, 3.0);
        c1.radius = 2.0;
        System.out.println("Area of c1 = " + c1.area());

        Circle c2 = new Circle( 1.0, new Point2D.Double(2.0, 3.0));
        //c2.radius = 2.0;
        System.out.println("Area of c2 = " + c2.getArea());

        Square s1 = new Square( 3.0, new Point2D.Double(4.0, 5.0));
        //s1.sideLength = 2.0;
        System.out.println("Area of s1 = " + s1.getArea());

        Shape s2 = new Square( 4.0, new Point2D.Double(5.0, 6.0));
        System.out.println("Area of s2 = " + s2.getArea());
    }
}
