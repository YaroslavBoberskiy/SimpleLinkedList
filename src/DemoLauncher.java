/**
 * Created by YB on 27.11.2015.
 */
public class DemoLauncher {

    private static SimpleLinkedList sll = new SimpleLinkedList();

    public static void main(String [ ] args)
    {
        sll.printList();
        sll.addFirst("A");
        sll.printList();
        sll.addFirst("B");
        sll.printList();
        sll.addFirst("C");
        sll.printList();
        System.out.println("Size: " + sll.getSize());
        sll.addLast("J");
        sll.printList();
        System.out.println("Size: " + sll.getSize());
        sll.addLast("Y");
        sll.printList();
        System.out.println("Size: " + sll.getSize());
        sll.addAfter("G", "A");
        sll.printList();
        System.out.println("Size: " + sll.getSize());
        sll.addAfter("K", "G");
        sll.printList();
        System.out.println("Size: " + sll.getSize());
        sll.addAfter("M", "Y");
        sll.printList();
        System.out.println("Size: " + sll.getSize());
    }

}
