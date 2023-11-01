package coredatastructures;

/** Class that represents a notebook computer. */
public class Notebook extends Computer {
    // Data Fields
    private double screenSize;
    private double weight;

    // Methods
    /** Initializes a Notebook object with all properties specified.
     @param man The computer manufacturer
     @param proc The processor type
     @param ram The RAM size
     @param disk The disk size
     @param procSpeed The processor speed
     @param screen The screen size
     @param wei The weight
     */
    public Notebook(String man, String proc, int ram, int disk,
                    double procSpeed, double screen, double wei) {
        super(man, proc, ram, disk, procSpeed);
        screenSize = screen;
        weight = wei;
    }
}