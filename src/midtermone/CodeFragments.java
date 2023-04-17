/*
 * Course: CS-2852
 * Spring 2023
 * Midterm 1 Key code
 * Name: John DeMastri
 * Created: 04/05/2023
 */
package midtermone;

/**
 * fragment analysis
 */
public class CodeFragments {
    private static final int TEN = 10;
    private static final int TWENTY = 20;

    /**
     * method to house fragments
     *
     * @param n - collection size...typ
     */
    public static void someFunction(int n) {

        // code fragment 1
        System.out.println("Fragment 1");
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(++count + ": (" + i + ", " + j + ")");
            }
        }

        // code fragment 2
        System.out.println("Fragment 2");
        count = 0;
        for (int i = 0; i < TEN; i++) {
            for (int j = 2 * n - 1; j >= 0; j--) {
                System.out.println(++count + ": (" + i + ", " + j + ")");
            }
        }

        // code fragment 3
        System.out.println("Fragment 3");
        count = 0;
        for (int i = 0; i < TEN; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(++count + ": (" + i + ", " + j + ")");
            }
        }

        // code fragment 4
        System.out.println("Fragment 4");
        count = 0;
        int bucketCount = 3;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + 1 == bucketCount) {
                    System.out.println(++count + ": (" + i + ", " + j + "), " + bucketCount);
                }
            }
        }
    }

    public static void main(String[] args) {
        someFunction(TEN);
    }

}
