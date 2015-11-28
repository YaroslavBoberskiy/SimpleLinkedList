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

        node.obj = obj;
        size ++;
    }

    public void addAfter(Object objToAdd, Object objBefore) {

    }

    public int getSize() {

        return size;
    }

    private class Node {

        private Object obj;
        private Node nodeNext;
    }

}
