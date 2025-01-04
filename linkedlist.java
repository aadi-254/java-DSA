public class linkedlist {
    // LinkedList Implementation in Java

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Head of the list

    // Method to insert a node at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Method to delete a node by value
    public void delete(int key) {
        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        // If the head node itself holds the key
        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        // If the key was not found
        if (temp.next == null) {
            System.out.println("Value " + key + " not found in the list.");
            return;
        }

        // Unlink the node
        temp.next = temp.next.next;
    }

    public static void main(String[] args) {
        linkedlist list = new linkedlist();

        // Insert elements into the linked list
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        // Display the list
        System.out.println("Original List:");
        list.display();

        // Delete a node
        System.out.println("After deleting 20:");
        list.delete(20);
        list.display();

        // Attempt to delete a non-existent value
        System.out.println("Trying to delete 50:");
        list.delete(50);
        list.display();
    }


}
