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

        if (root == null & this.getSize() == 0) {
            this.addFirst(obj);
        }

        while (node.nodeNext != null) {
            node = node.nodeNext;
        }

        node.nodeNext = node;
        node.obj = obj;
        size++;
    }

    public void addAfter(Object objToAdd, Object objBefore) {
        Node node = new Node();
        node.obj = objToAdd;

        if (this.getSize() > 1) {

            Node current = root;

            for (int i = 0; i < this.size; i++) {

                if (objBefore.equals(current.obj)) {
                    if (current.nodeNext == null) {
                        System.out.println("Element has last position");
                        break;
                    } else {
                        node.nodeNext = current.nodeNext;
                        current.nodeNext = node;
                        break;
                    }
                }
                current = current.nodeNext;
                if (current == null) {
                    throw new IllegalStateException("No element");
                }

            }

            size++;

        } else {
            System.out.println("Cant insert!");
        }
    }

    public int getSize() {

        return size;
    }

    private class Node {

        private Object obj;
        private Node nodeNext;
    }

}
