import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by YB on 27.11.2015.
 */
public class SimpleLinkedList implements Iterable<Object> {

    private Node root;
    private int size;

    public SimpleLinkedList() {
        size = 0;
    }

    public void addFirst(Object obj) {
        Node node = new Node();
        node.obj = obj;
        if (root == null) {
            size++;
            root = node;
        } else {
            node.nodeNext = root;
            root = node;
            size++;
        }
    }

    public void addLast(Object obj) {
        Node node = new Node();
        Node cp = root;

        if (root == null & this.getSize() == 0) {
            this.addFirst(obj);
        } else {
            node.obj = obj;
            while (cp.nodeNext != null) {
                cp = cp.nodeNext;
            }

            cp.nodeNext = node;
            node.nodeNext = null;
            size++;
        }
    }

    public void addAfter(Object objToAdd, Object objBefore) {
        Node node = new Node();
        node.obj = objToAdd;

        if (this.getSize() > 1) {

            Node cp = root;

            for (int i = 0; i < this.size; i++) {

                if (objBefore.equals(cp.obj)) {
                    if (cp.nodeNext == null) {
                        System.out.println("Element has last position");
                        break;
                    } else {
                        node.nodeNext = cp.nodeNext;
                        cp.nodeNext = node;
                        size++;
                        break;
                    }
                }
                cp = cp.nodeNext;
                if (cp == null) {
                    throw new IllegalStateException("No element");
                }
            }
        } else {
            System.out.println("Cant insert!");
        }
    }

    public void remove(int idx) {

        if (idx >= 0 && idx < size) {

            Node cp = root;
            int cpIdx = 0;

            if (root == null && getSize() == 0) {
                throw new IllegalStateException("list is already empty");
            }

            if (idx == 0 && cp.nodeNext == null) {
                root = null;
                size--;
            } else {
                int tempIdx = 0;
                while (cp.nodeNext != null) {
                    if (cpIdx == idx) {
                        while (cp.nodeNext != null) {
                            cp.obj = cp.nodeNext.obj;
                            cp = cp.nodeNext;
                            tempIdx++;
                            if ((size - 1 - tempIdx) == idx) {
                                cp.obj = null;
                                cp.nodeNext = null;
                            }
                        }

                        size --;
                        break;
                    }
                    cp = cp.nodeNext;
                    cpIdx++;
                    tempIdx++;
                }
            }
        } else {
            System.out.println("There is no element with such index in the list!");
        }
    }

    public int getSize() {

        return size;
    }

    public void printList() {
        if (size == 0) {
            System.out.println("List is empty!");
        } else {
            Node cp = root;
            while (cp.nodeNext != null) {
                System.out.print(cp.obj + ", ");
                cp = cp.nodeNext;
            }

            System.out.println(cp.obj);

        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new SLLIterator();
    }


    private class Node {

        private Object obj;
        private Node nodeNext;
    }

    public class SLLIterator implements Iterator<Object> {

        Node node;

        @Override
        public boolean hasNext() {

            return (node == null && root != null) || (node != null && node.nodeNext != null);

        }

        @Override
        public Object next() {

            if (node == null && root != null) {
                node = root;
                return node.obj;
            }

            if (hasNext()) {
                node = node.nodeNext;
                return node.obj;
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
