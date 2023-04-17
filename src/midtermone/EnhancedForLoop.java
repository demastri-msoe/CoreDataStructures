/*
 * Course: CS-2852
 * Spring 2023
 * Midterm 1 Key code
 * Name: John DeMastri
 * Created: 04/05/2023
 */

package midtermone;

import java.util.Iterator;
import java.util.List;

/**
 * fragment analysis
 *
 * @param <E> elts of collection
 */
public class EnhancedForLoop<E> {


    /**
     * highlight enhanced for-loop
     *
     * @param collection
     */
    public void someMethod(List<E> collection) {

        // a - enhanced for-loop
        for (E elt : collection) {
            elt.toString();   // do something
        }
        // b - using iterator
        Iterator iter = collection.iterator();
        while (iter.hasNext()) {
            E elt = (E) iter.next();
            elt.toString();   // do something
        }
        // b - using index
        for (int i = 0; i < collection.size(); i++) {
            E elt = collection.get(i);
            elt.toString();   // do something
        }

    }
}
