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

        BinaryTree<String> leftSub = new BinaryTree<>(new BinaryTree.Node<>("20"));
        BinaryTree<String> rightSub = new BinaryTree<>(new BinaryTree.Node<>("30"));
        BinaryTree<String> rightSubRoot = new BinaryTree<>("+", leftSub, rightSub);

        BinaryTree<String> left = new BinaryTree<>(new BinaryTree.Node<>("50"));
        BinaryTree<String> root = new BinaryTree<>("*", left, rightSubRoot);


        System.out.println(root.toString());
    }
}