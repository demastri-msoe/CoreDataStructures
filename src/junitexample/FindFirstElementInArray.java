/*
 * Course: CS-2852
 * Spring 2023
 * Midterm 1 Key code
 * Name: John DeMastri
 * Created: 04/05/2023
 */

package junitexample;

import java.util.List;

/**
 * exercise junit tests from here
 */
public class FindFirstElementInArray {

    /**
     * simple method to write tests against
     *
     * @param list
     * @param target
     * @return first instance of target found in list
     */
    public String findEltInArray(List<String> list, String target) {
        for (String e : list) {
            if (e == target) {
                return e;
            }
        }
        return null;
    }
}
