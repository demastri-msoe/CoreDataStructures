package finalexamprep;

import com.sun.source.tree.CaseLabelTree;

import java.util.*;

public class IntegerList {
    private static class IntegerNode {
        private Integer data;
        private IntegerNode next = null;

        public IntegerNode(Integer data, IntegerNode next) {
            this.data = data;
            this.next = next;
        }
    }

    IntegerNode head;

    public void addFirst(Integer data) {
        head = new IntegerNode(data, head);
    }

    public void add(Integer data) {
        IntegerNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new IntegerNode(data, null);
    }

    public void removeGreaterThan(Integer max) {
        // O(n), each element is visited once.
        // On no removal, no extra work is done
        // On removal, constant extra work is done

        // If implemented as an ArrayList O(n^2), each element is visited once.
        // On no removal, no extra work is done
        // On removal, potentially O(n) extra work is done

        IntegerNode curNode = head;
        IntegerNode priorNode = null;
        boolean updated = false;
        while (curNode != null) {
            // remove bigger nodes
            if (curNode.data > max) {
                updated = true;
                if (priorNode == null) {
                    head = curNode.next;
                } else {
                    priorNode.next = curNode.next;
                }
            }
            if (updated == false) {
                priorNode = curNode;
            }
            curNode = curNode.next;
        }
    }

    public static void main(String[] args) {
        IntegerList l = new IntegerList();
        l.addFirst(10);
        l.add(5);
        l.add(8);
        System.out.print("Original: ");
        printList(l);
        System.out.print("Trim 20: ");
        l.removeGreaterThan(20);
        printList(l);
        System.out.print("Trim 10: ");
        l.removeGreaterThan(10);
        printList(l);
        System.out.print("Trim 9: ");
        l.removeGreaterThan(9);
        printList(l);
        System.out.print("Trim 7: ");
        l.removeGreaterThan(7);
        printList(l);
        System.out.print("Trim 3: ");
        l.removeGreaterThan(3);
        printList(l);

        BSTNode rightk1 = new BSTNode(6, null, null);
        BSTNode leftk1 = new BSTNode(11, null, null);
        BSTNode leftk2 = new BSTNode(6, null, null);
        BSTNode left = new BSTNode(4, leftk1, leftk2);
        BSTNode right = new BSTNode(3, null, rightk1);
        root = new BSTNode(1, left, right);
        System.out.print("findOdd returned: " + findOdd());
    }

    public static void printList(IntegerList l) {
        IntegerNode n = l.head;
        System.out.print("<");
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println(">");
    }

    public ArrayList<Object> deepCopy(ArrayList<Object> original) {
        //ArrayList<Object> outList = new ArrayList<Object>(original.size());
        //for (Object o : original) {
        //    outList.add(o);
        //}
        return null; // outList;
    }

    public static ArrayList<Integer> square(List<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            result.add(i * i);
        }
        return result;
    }

    static class BSTNode {
        BSTNode left;
        BSTNode right;
        int data;

        BSTNode(int data, BSTNode left, BSTNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static BSTNode root;

    public static int findOdd() {
        return findOdd(root, 0);
    }

    public static int findOdd(BSTNode n, int curSum) {
        if (n == null) {
            return curSum;
        }
        return (n.data % 2 == 1 ? 1 : 0)
                + findOdd(n.left, 0)
                + findOdd(n.right, 0);
    }

    public class ArrayListJPD<E> implements List<E> {
        private E[] data = (E[]) new Object[10];
        private int size = 0;

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            for (E entry : data) {
                if (entry != null) {
                    return false;
                }
            }
            return true;
        }

        public boolean contains(Object o) {
            if (o == null) {
                throw new NullPointerException();
            }
            try {
                E thisObect = (E) o;
                for (E elt : data) {
                    if (thisObect.equals(elt)) {
                        return true;
                    }
                }
            } catch (ClassCastException e) {
                throw new ClassCastException();
            }
            return false;
        }

        @Override
        public Iterator<E> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(E e) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public E get(int index) {
            return null;
        }

        @Override
        public E set(int index, E element) {
            return null;
        }

        @Override
        public void add(int index, E element) {

        }

        @Override
        public E remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<E> listIterator() {
            return null;
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            return null;
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            return null;
        }
    }

}