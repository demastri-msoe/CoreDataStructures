package coredatastructures;

/** Class that represents a computer. */
public class Computer {
    // Data Fields
    private String manufacturer;
    private String processor;
    private int ramSize;
    private int diskSize;
    private double processorSpeed;
    // Methods
    /** Initializes a Computer object with all properties specified.
     @param man The computer manufacturer
     @param processor The processor type
     @param ram The RAM size
     @param disk The disk size
     @param procSpeed The processor speed
     */
    public Computer(String man, String processor, int ram,
                    int disk, double procSpeed) {
        manufacturer = man;
        this.processor = processor;
        ramSize = ram;
        diskSize = disk;
        processorSpeed = procSpeed;
    }
    public double computePower() { return ramSize * processorSpeed; }
    public int getRamSize() { return ramSize; }
    public double getProcessorSpeed() { return processorSpeed; }
    public int getDiskSize() { return diskSize; }
    // Insert other accessor and modifier methods here.
    public String toString() {
        String result = "Manufacturer: " + manufacturer +
                "\nCPU: " + processor +
                "\nRAM: " + ramSize + " gigabytes" +
                "\nDisk: " + diskSize + " gigabytes" +
                "\nProcessor speed: " + processorSpeed + " gigahertz";
        return result;
    }
}