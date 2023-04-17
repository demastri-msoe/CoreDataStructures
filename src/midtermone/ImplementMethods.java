/*
 * Course: CS-2852
 * Spring 2023
 * Midterm 1 Key code
 * Name: John DeMastri
 * Created: 04/05/2023
 */

package midtermone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Method implementation question
 */
public class ImplementMethods {

    /**
     * intended to show logic and O() thought process
     *
     * @param nbrs given data
     * @return largest odd integer
     */
    public static Integer findLargestOddNumber(ArrayList<Integer> nbrs) {
        // initialize the return value
        Integer biggestOdd = Integer.MIN_VALUE;
        // iterate over the set
        for (int i = 0; i < nbrs.size(); i++) {
            Integer thisInt = nbrs.get(i);          // is this O(1) for ArrayList?  for linkedList?
            // maintain current return value
            if (thisInt % 2 == 1 && thisInt > biggestOdd) {
                biggestOdd = thisInt;
            }
        }
        // return the result
        return biggestOdd;
    }

    /**
     * intended to show logic and O() thought process
     *
     * @param stringList given data
     * @param threshold  count strings longer than this
     * @return largest odd integer
     */
    public static Double printAverageOfLongStringLengths(List<String> stringList, int threshold) {
        // init local variables
        int totalLength = 0;
        Double longItemCount = 0.0;
        // create iterator
        Iterator<String> iter = stringList.iterator();
        // iterate over list
        while (iter.hasNext()) {
            String thisString = iter.next();
            // manage output data
            if (thisString.length() > threshold) {
                longItemCount++;
                totalLength += thisString.length();
            }
        }
        // calculate and return output data
        return totalLength / (longItemCount == 0 ? 1.0 : Double.valueOf(longItemCount));
    }


}
