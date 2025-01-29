package Assignment3;

public class MainLL {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        sll.insertInLinkedList(1,0);
        sll.insertInLinkedList(2,1);
        sll.insertInLinkedList(3,3);
        sll.insertInLinkedList(4,4);

        sll.traverseInLinkedList();
        sll.searchNode(2);
        sll.deleteNode(1);
        sll.traverseInLinkedList();
        sll.deleteNode(3);
        sll.traverseInLinkedList();
        sll.deleteNode(4);
        sll.traverseInLinkedList();
        sll.deleteNode(2);
        sll.traverseInLinkedList();
    }
}
