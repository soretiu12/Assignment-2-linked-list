// Node class to represent a node in the linked list
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class to represent a singly linked list and its operations
class LinkedList {
    private Node head;

    // Method to insert a node at a specified position in the linked list
    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                System.out.println("Position " + position + " not found in the list");
            } else {
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    // Method to delete a node at a specified position in the linked list
    public void deleteAtPosition(int position) {
        if (position == 1) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            if (current == null || current.next == null) {
                System.out.println("Position " + position + " not found in the list");
            } else {
                current.next = current.next.next;
            }
        }
    }

    // Method to delete the node that occurs after a given node in the linked list
    public void deleteAfterNode(Node prevNode) {
        if (prevNode != null && prevNode.next != null) {
            prevNode.next = prevNode.next.next;
        }
    }

    // Method to search for a node with a specific value in the linked list
    public boolean searchNode(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true; // Node found
            }
            current = current.next;
        }
        return false; // Node not found
    }
}

// Stack class to implement a stack using linked lists
class Stack {
    private Node top;

    // Method to push an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Method to pop the top element from the stack
    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1; // Return an invalid value
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    // Method to peek at the top element of the stack
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1; // Return an invalid value
        }
        return top.data;
    }
}

// Main class to test the LinkedList and Stack implementations
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtPos(10, 1);
        list.insertAtPos(20, 2);
        list.insertAtPos(30, 3);
        
        list.deleteAtPosition(2);
        
        Node node1 = new Node(40);
        list.deleteAfterNode(node1);

        System.out.println("Is 20 in the list? " + list.searchNode(20));
        
        Stack stack = new Stack();
        
        stack.push(50);
        stack.push(60);
        
        System.out.println("Popped: " + stack.pop());
        
        System.out.println("Peek: " + stack.peek());
    }
}