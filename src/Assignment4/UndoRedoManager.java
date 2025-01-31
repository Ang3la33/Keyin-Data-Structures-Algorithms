package Assignment4;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement an application that support undo/redo functionality. Use a linked list to maintain a sequence of states.\
 * Each state change is stored as a node in the list, allowing for easy navigation
 * 1<>2<>3<>4<>5
 */

public class UndoRedoManager<T> {
    private class Node {
        private T state;
        private Node prev;
        private Node next;
        private Node (T state) {
            this.state = state;
        }

    }
    private Node currentState;
    private Node head;

    //Undo operation
    public T undo(){
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            return currentState.state;
        }
        System.out.println("No previous state!");
        return null;
    }

    //Perform an operation
    public void  addState (T newState) {
        Node newNode = new Node(newState);

        if (currentState != null) {
            currentState.next = newNode;
            newNode.prev = currentState;
        } else {
            head = newNode;
        }
        currentState = newNode;
    }

    //Redo Operation
    public T redo(){
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            return currentState.state;
        }
        System.out.println("No next state!");
        return null;
    }

    public void display() {
        Node temp = head;
        StringBuilder result = new StringBuilder();

        while (temp != null && temp != currentState.next) {
            result.append(temp.state);
            if (temp.next != null && temp.next != currentState.next) {
                result.append(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {

        UndoRedoManager<String> manager = new UndoRedoManager<>();

        manager.addState("1");
        manager.addState("2");
        manager.addState("3");
        manager.addState("4");
        manager.addState("5");

        manager.display();

        System.out.println(manager.undo());
        System.out.println(manager.undo());

        manager.display();

        System.out.println(manager.undo());

        manager.display();

        System.out.println(manager.redo());
        System.out.println(manager.redo());
        System.out.println(manager.redo());

        manager.display();

    }
}
