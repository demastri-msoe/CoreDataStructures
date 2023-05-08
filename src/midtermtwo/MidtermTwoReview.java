package midtermtwo;

import coredatastructures.BinarySearchTree;
import coredatastructures.BinaryTree;

public class MidtermTwoReview<E extends Comparable<E>> {

    public E nonRecursiveLargest(BinarySearchTree<E> root) {
        if (root == null) {
            return null;
        }
        E largest = null;
        do {
            largest = root.getData();
            root = (BinarySearchTree<E>) root.getRightSubtree();
        } while (root != null);
        return largest;
    }

    public E recursiveFindLargest(BinaryTree<E> root) {
        if (root == null) {
            return null;
        }
        E largest = root.getData();
        E lLargest = recursiveFindLargest(root.getLeftSubtree());
        if (lLargest != null && (largest == null || lLargest.compareTo(largest) > 0)) {
            largest = lLargest;
        }
        E rLargest = recursiveFindLargest(root.getRightSubtree());
        if (rLargest != null && (largest == null || rLargest.compareTo(largest) > 0)) {
            largest = rLargest;
        }

        return largest;
    }

    /**
     * Given the number of dog, returns the number of eyes.
     * This method assumes each dog has two ears.
     *
     * @param dogCount the number of dogs
     * @return the total number of ears
     **/
    public static int dogEars(int dogCount) {
        if (dogCount <= 0) {
            return 0;
        }
        return 1 + dogEars(dogCount - 1) + 1;
    }
    public static int otherDogEars(int dogCount) {
        return otherDogEars(dogCount, 0);
    }
    public static int otherDogEars(int dogCount, int curEars) {
        if(dogCount == 0) { return curEars; }
        curEars += 2;
        int update = otherDogEars(dogCount-1, curEars);
        return update;
    }

    public String toString() {
        String root;
        String result = "";// = toString(root); // <- method you are writing
        result = result.length() < 3 ? "" : result.substring(0, result.length() - 2);
        return "[" + result + "]";
    }
}