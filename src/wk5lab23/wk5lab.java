package wk5lab23;

import java.util.Arrays;
import java.util.List;

public class wk5lab {

    abstract static public class Shape {
        // Shape - an abstract class with the following methods:
        private double centerX;
        private double centerY;

        Shape(double centerX, double centerY) {
            this.centerX = centerX;
            this.centerY = centerY;
        }

        double getCenterX() {
            return centerX;
        }

        double getCenterY() {
            return centerY;
        }

        abstract double getArea();

        abstract double getPerimeter();
    }

    public static class Circle extends Shape {
        //Circle - a class with the following methods:
        private double radius;

        Circle(double centerX, double centerY, double radius) {
            super(centerX, centerY);
            this.radius = radius;
        }

        double getArea() {
            return Math.PI * radius * radius;
        }

        double getPerimeter() {
            return 2.0 * Math.PI * radius;
        }

        @Override
        public String toString() {
            return "Circle: " + getCenterX() + ", " + getCenterY() + ", " + radius;
        }
    }

    public static class Rectangle extends Shape {
        //Rectangle - a class with the following methods:
        private double width;
        private double height;

        Rectangle(double centerX, double centerY, double width, double height) {
            super(centerX, centerY);
            this.width = width;
            this.height = height;
        }

        double getHeight() {
            return height;
        }

        double getWidth() {
            return width;
        }

        double getArea() {
            return height * width;
        }

        double getPerimeter() {
            return 2 * (height + width);
        }

        @Override
        public String toString() {
            return "Rectangle: " + getCenterX() + ", " + getCenterY() + ", " + width + ", " + height;
        }
    }


    List<String> doubleUpNull(List<String> s) {
        if (s == null) {
            return null;
        }
        return s.stream().map(e -> {
            if (e == null) {
                return null;
            }
            return (e + e);
        }).toList();
    }

    List<String> quoteEm(List<String> s) {
        List<Integer> x = s.stream().filter(e -> e.substring(0, 1).equals("x")).map(String::length).toList();

        return s.stream().map(e -> {
            return "\"" + e + "\"";
        }).toList();
    }

    List<Integer> squareEm(List<Integer> s) {
        return s.stream().map(e -> {
            return e * e;
        }).toList();
    }

    List<Integer> noOdd(List<Integer> l) {
        return l.stream().filter(e -> e % 2 == 0).toList();
    }

    List<Integer> noOddAndSquareNegs(List<Integer> l) {
        return l.stream().filter(e -> e % 2 == 0).map(e -> {
            if (e < 0) {
                return e * e;
            }
            return e;
        }).toList();
    }

    List<String> noVowels(List<String> l) {
        return l.stream().map(e -> {
            return e.replaceAll("[aeiouAEIOU]", "-");
        }).toList();
    }

    List<Shape> onlyCircles(List<Shape> s) {
        return s.stream().filter(e -> e instanceof Circle).toList();
    }

    List<Shape> onlySquares(List<Shape> s) {
        return s.stream().filter(e -> e instanceof Rectangle
                && ((Rectangle) e).getHeight() == ((Rectangle) e).getWidth()).toList();
    }

    double totalArea(List<Shape> s) {
        return s.stream().mapToDouble(Shape::getArea).sum();
    }

    double totalAreaInFirstQuadrant(List<Shape> s) {
        return s.stream().filter(e -> e.getCenterX() >= 0 && e.getCenterY() >= 0)
                .mapToDouble(Shape::getArea).sum();
    }

    int getTotalLengthOfStringsStartingLessOrEqualToE(List<String> l) {
        return l.stream()
                .filter(s -> 'a' <= s.toLowerCase().charAt(0) && s.toLowerCase().charAt(0) <= 'e')
                .mapToInt(s -> s.length())
                .sum();
    }

    public static void printList(List l) {
        boolean start = true;
        if (l == null) {
            System.out.println(" null ");
        } else {
            System.out.print("[ ");
            for (Object o : l) {
                if (!start) {
                    System.out.print(", ");
                }
                if (o == null) {
                    System.out.print("null");
                } else {
                    System.out.print(o.toString());
                }
                start = false;
            }
            System.out.println(" ]");
        }
    }

    public static void main(String[] args) {
        wk5lab lab = new wk5lab();

        printList(lab.doubleUpNull(Arrays.asList("a", "b")));
        printList(lab.doubleUpNull(Arrays.asList("", null)));
        printList(lab.doubleUpNull(null));
        System.out.println();

        printList(lab.quoteEm(Arrays.asList("abc", "def")));
        System.out.println();

        printList(lab.squareEm(Arrays.asList(0, 1, 4)));
        System.out.println();

        printList(lab.noOdd(Arrays.asList(1, 2, 3, 4)));
        System.out.println();

        printList(lab.noOddAndSquareNegs(Arrays.asList(1, -2, -3, 4)));
        System.out.println();

        printList(lab.noVowels(Arrays.asList("happy", "birthday")));
        System.out.println();

        printList(lab.onlyCircles(Arrays.asList(
                new Circle(0, 0, 1),
                new Rectangle(3, 3, 1, 2),
                new Circle(0, 0, 3),
                new Rectangle(1, 2, 1, 2)
        )));
        System.out.println();

        printList(lab.onlySquares(Arrays.asList(
                new Circle(0, 0, 1),
                new Rectangle(3, 3, 1, 1),
                new Circle(0, 0, 3),
                new Rectangle(1, 2, 1, 2),
                new Circle(0, 0, 3),
                new Rectangle(1, 2, 3, 3)
        )));
        System.out.println();

        System.out.println(lab.totalArea(Arrays.asList(
                new Circle(0, 0, 1),
                new Rectangle(3, 3, 1, 1),
                new Circle(0, 0, 2)
        )));
        System.out.println();

        System.out.println(lab.totalAreaInFirstQuadrant(Arrays.asList(
                new Circle(-1, 0, 1),
                new Circle(0, -1, 1),
                new Rectangle(3, 3, 4, 3),
                new Circle(-1, -1, 2)
        )));
    }

}
