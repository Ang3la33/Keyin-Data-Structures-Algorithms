package Assignment3;

public class SingleLinkedList {

    public Node head;
    public Node tail;
    public int size;

    // Create a Linked List
    public Node createLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    // Insert into a Linked List
        // 0. If the Link doesn't exist
        // 1. Inserting at the beginning
        // 2. Inserting at the ending
        // 3. Inserting anywhere

    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            tail.next = node;
            node.next = null;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = node;
            node.next = nextNode;
        }
        size++;
    }

    // Traverse a Linked List
    public void traverseInLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size -1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
            System.out.print("\n");
        }
    }

    // Search for a node
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node: " + tempNode.value + " at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    // Assignment 3 - Delete a node from the Linked List
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("SLL does not exist");
            return;
        }
        if (location == 0) { // Delete the head (first node)
            if (head == tail) {
                /*
                If the head is the same as the tail that means that the list only contains 1 value,
                therefore deleting the head deletes the entire list.
                 */
                head = null;
                tail = null;
            } else {
                /*
                If the head and tail are not the same this means there is more than one value in the list,
                therefore deleting the head of the list causes the next node in the list to become the head.
                 */
                head = head.next;
            }
        } else if (location >= size -1) { // Delete the tail (last node)
            Node tempNode = head;
            while (tempNode.next != tail) { // Traverse tempNode until it gets to tail
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            tail = tempNode;
            if (head == tail) {
                head = null;
            }
        } else { // Delete a node between head and tail
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            tempNode.next = tempNode.next.next; // Skip over the node to delete
        }
        size--; // Reduce the list size after deleting a node
    }

}
