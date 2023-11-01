/*
 * Course: CS-2852
 * Spring 2023
 * Core Data Structures Driver
 * Name: John DeMastri
 * Created: 03/22/2023
 */
package coredatastructures;

/**
 * Program to execute various samples and algorithms in Data Structures
 */
public class Driver {
    public static void main(String[] args) {

        testBinaryTree();

        testBinarySearchTree();

        //testOpenAddressing();
    }

    private static void testBinaryTree() {
        BinaryTree<String> leftSub = new BinaryTree<>(new BinaryTree.Node<>("20"));
        BinaryTree<String> rightSub = new BinaryTree<>(new BinaryTree.Node<>("30"));
        BinaryTree<String> rightSubRoot = new BinaryTree<>("+", leftSub, rightSub);

        BinaryTree<String> left = new BinaryTree<>(new BinaryTree.Node<>("50"));
        BinaryTree<String> root = new BinaryTree<>("*", left, rightSubRoot);

        String outString = root.find("20");
        System.out.println("Expected 20, got: " + outString);
        outString = root.find("30");
        System.out.println("Expected 30, got: " + outString);
        outString = root.find("200");
        System.out.println("Expected 200, got: " + outString);

        System.out.println(root.toString());
        System.out.println(root.height());
        System.out.println(root.recursiveFindLargest());

        System.out.println("-----------------------");
    }

    private static void testBinarySearchTree() {
        int[] nbrsToAdd = new int[]{60, 25, 85, 15, 40, 70, 95, 5, 20, 35, 50, 65, 80, 90, 10, 30, 45, 55, 75};
        BinarySearchTree<Integer> intTree = new BinarySearchTree<>();
        for (int i : nbrsToAdd) {
            intTree.add(i);
        }
        System.out.println(intTree.toString());

        System.out.println("-----------------------");
        intTree.delete(60);
        System.out.println(intTree.toString());
        System.out.println(intTree.height());
        System.out.println(intTree.nonRecursiveLargest());
        System.out.println(intTree.recursiveFindLargest());
        System.out.println("-----------------------");
    }

    private static void testOpenAddressing() {
        System.out.println("Checking Open Addressing");
        JDHashMap<Integer, String> ht = new HashTableOpen<>();
        ht.put(1, "One");
        ht.put(2, "Two");
        ht.put(3, "Three");
        if (!ht.contains(2) || ht.contains(0) || ht.size() != 3) {
            System.out.println("Something's up with contains");
        }
        System.out.println(ht.toString());
        if (ht.remove(7) != null || ht.remove(2) == null || ht.size() != 2) {
            System.out.println("Something's up with remove");
        }
        System.out.println(ht.toString());
        ht.put(2, "Two");
        System.out.println(ht.toString());

        System.out.println("Checking Chaining");
        JDHashMap<Integer, String> htChain = new HashTableChain<>();
        htChain.put(1, "One");
        htChain.put(2, "Two");
        htChain.put(3, "Three");
        if (!htChain.contains(2) || htChain.contains(0) || htChain.size() != 3) {
            System.out.println("Something's up with contains");
        }
        System.out.println(htChain.toString());
        if (htChain.remove(7) != null || htChain.remove(2) == null || htChain.size() != 2) {
            System.out.println("Something's up with remove");
        }
        System.out.println(htChain.toString());
        htChain.put(2, "Two");
        System.out.println(htChain.toString());   }
}