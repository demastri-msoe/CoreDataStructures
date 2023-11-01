package finalinclassreview;

import java.util.LinkedList;
import java.util.ListIterator;

public class review<E> {

    public class StringList {
        private static class StringNode {
            private String item;
            private StringNode next = null;

            public StringNode(String item, StringNode next) {
                this.item = item;
                this.next = next;
            }
        }

        StringNode head;

        public void addFirst(String item) {
            head = new StringNode(item, head);
        }

        public void removeAllButEnds() {
            StringNode lastnode = head;
            while( lastnode.next != null)
                lastnode = lastnode.next;
            head.next = lastnode;
        }

        public String getMiddle() {
            // you will write this
            return "";
        }

        public void refRemoveAllButEnds() {
            StringNode curNode = (head == null ? null : head.next);
            while (curNode != null && curNode.next != null) {
                // at second to next to last node, so remove this node
                StringNode nextNode = curNode.next;
                curNode.next = nextNode.next;
            }
        }

        public String refGetMiddle() {
            // get count
            int count = 0;
            StringNode curNode = head;
            while (curNode != null) {
                count++;
                curNode = curNode.next;
            }

            // get item
            curNode = head;
            for (int i = 0; i < (count - 1) / 2; i++) {
                curNode = curNode.next;
            }
            return curNode == null ? "" : curNode.item;
        }

    }


    void copy(LinkedList<E> src, LinkedList<E> dest) {
        for (E elt : src) {
            dest.add(elt);
        }
    }

    void refCopy(LinkedList<E> src, LinkedList<E> dest) {
        ListIterator<E> it = src.listIterator();
        while (it.hasNext()) {
            dest.add(it.next());
        }
        // O( n ) because the iterator accesses are O(1) each

    }

    Node<E> root;

    public class Node<E> {
        Node<E> left;
        Node<E> right;
        E value;

        public int countChildNodes(Node<E> root) {
            return countChildNodesRec(root);
        }

        public int countChildNodesRec(Node<E> n) {
            if( n == null)
                return 0;
            return 1+countChildNodes(n.right)+countChildNodes(n.left);

        }

        public int refCountChildNodes(Node<E> n) {
            if (n == null) {
                return 0;
            }
            return 1 + refCountChildNodes(n.left) + refCountChildNodes(n.right);
        }

    }

    LinkedList<E>[] table;

    String hashToString() {
        return "";
    }

    String refHashToString() {
        String outString = "";
        for (LinkedList<E> elts : table) {
            if( elts != null )
                for (E elt : elts) {
                    outString += elt.toString() + " ";
                }
        }
        return outString;
    }

}
