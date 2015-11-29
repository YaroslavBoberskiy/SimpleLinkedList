/**
 * Created by YB on 27.11.2015.
 */
public class SimpleLinkedList {

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

    private class Node {

        private Object obj;
        private Node nodeNext;
    }

}
