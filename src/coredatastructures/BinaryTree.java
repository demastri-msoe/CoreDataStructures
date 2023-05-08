package coredatastructures;

import java.util.function.BiConsumer;

public class BinaryTree<E extends Comparable<E>> {

    protected Node<E> root;

    /**
     * Class to encapsulate a tree node.
     */
    protected static class Node<E> {
        // Data Fields
        /**
         * The information stored in this node.
         */
        protected E data;
        /**
         * Reference to the left child.
         */
        protected Node<E> left;
        /**
         * Reference to the right child.
         */
        protected Node<E> right;

        // Constructors

        /**
         * Construct a node with given data and no children.
         *
         * @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
        // Methods

        /**
         * Return a string representation of the node.
         *
         * @return a string representation of data
         */
        public String toString() {
            return data.toString();
        }
    }


    public BinaryTree() {
        root = null;
    }

    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root leftTree
     * as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    /**
     * Return the left subtree.
     *
     * @return The left subtree or null if either the root or
     * the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<>(root.left);
        } else {
            return null;
        }
    }

    /**
     * Return the right subtree.
     *
     * @return The left subtree or null if either the root or
     * the left subtree is null
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<>(root.right);
        } else {
            return null;
        }
    }

    /**
     * Determine whether this tree is a leaf.
     *
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        return root.left == null && root.right == null;
    }

    public E getData() {
        return root == null ? null : root.data;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        inOrderTraverse((e, d) -> {
            if (e == null) return;    // uncomment if I don't want null pointers to show up as "null" text lines
            for (int i = 1; i < d; i++) {
                sb.append(" ");
            }
            sb.append(e);
            sb.append("\n");
        });
        return sb.toString();
    }

    // traversal methods

    public void preOrderTraverse(BiConsumer<E, Integer> consumer) {
        preOrderTraverse(root, 1, consumer);
    }

    private void preOrderTraverse(Node<E> node, int depth,
                                  BiConsumer<E, Integer> consumer) {
        if (node == null) {
            consumer.accept(null, depth);
        } else {
            consumer.accept(node.data, depth);
            preOrderTraverse(node.left, depth + 1, consumer);
            preOrderTraverse(node.right, depth + 1, consumer);
        }
    }

    public void inOrderTraverse(BiConsumer<E, Integer> consumer) {
        inOrderTraverse(root, 1, consumer);
    }

    private void inOrderTraverse(Node<E> node, int depth,
                                 BiConsumer<E, Integer> consumer) {
        if (node == null) {
            consumer.accept(null, depth);
        } else {
            inOrderTraverse(node.left, depth + 1, consumer);
            consumer.accept(node.data, depth);
            inOrderTraverse(node.right, depth + 1, consumer);
        }
    }

    public void postOrderTraverse(BiConsumer<E, Integer> consumer) {
        postOrderTraverse(root, 1, consumer);
    }

    private void postOrderTraverse(Node<E> node, int depth,
                                   BiConsumer<E, Integer> consumer) {
        if (node == null) {
            consumer.accept(null, depth);
        } else {
            postOrderTraverse(node.left, depth + 1, consumer);
            postOrderTraverse(node.right, depth + 1, consumer);
            consumer.accept(node.data, depth);
        }
    }

    /**
     * Starter method find.
     * pre: The target object must implement
     * the Comparable interface.
     *
     * @param target The Comparable object being sought
     * @return The object, if found, otherwise null
     */
    public E find(E target) {
        return find(root, target);
    }

    /**
     * Recursive find method.
     *
     * @param localRoot The local subtree’s root
     * @param target    The object being sought
     * @return The object, if found, otherwise null
     */
    private E find(Node<E> localRoot, E target) {
        if (localRoot == null) {
            return null;
        }

        // Compare the target with the data field at the root.
        if (localRoot == null || localRoot.data == null) {
            return null;
        }
        if (target.equals(localRoot.data)) {
            return localRoot.data;
        }
        E leftReturn = find(localRoot.left, target);
        if (leftReturn != null) {
            return leftReturn;
        }
        E rightReturn = find(localRoot.right, target);
        if (rightReturn != null) {
            return rightReturn;
        }
        return null;
    }

    int height() {
        return (root == null) ? 0 : height(root, 1);
    }

    int height(Node<E> n, int depth) {
        int lDepth = (n.left == null ? depth : height(n.left, depth + 1));
        int rDepth = (n.right == null ? depth : height(n.right, depth + 1));
        return lDepth > rDepth ? lDepth : rDepth;
    }

    public E recursiveFindLargest() {
        E largest = getData();
        E lLargest = (getLeftSubtree() == null ? null : getLeftSubtree().recursiveFindLargest());
        if (lLargest != null && (largest == null || lLargest.compareTo(largest) > 0)) {
            largest = lLargest;
        }
        E rLargest = (getRightSubtree() == null ? null : getRightSubtree().recursiveFindLargest());
        if (rLargest != null && (largest == null || rLargest.compareTo(largest) > 0)) {
            largest = rLargest;
        }

        return largest;
    }

}
