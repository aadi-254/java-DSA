public class circularlinkedlist {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; 

    // Method to insert a node at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head; 
        }
    }

    // Method to display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node temp = head;
        while (true) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            if (temp == head) {
                break; 
            }
        }
        System.out.println("(back to head)");
    }

    // Method to delete a node by value
    public void delete(int key) {
        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }

        Node current = head;
        Node prev = null;

        if (head.next == head && head.data == key) {
            head = null;
            return;
        }

        // Traverse the list to find the node to delete
        while (true) {
            if (current.data == key) {
                if (prev == null) {
                    Node temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    temp.next = head.next;
                    head = head.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
            if (current == head) {
                break; 
            }
        }

        System.out.println("Value " + key + " not found in the list.");
    }

    public static void main(String[] args) {
        circularlinkedlist list = new circularlinkedlist();

        // Insert elements into the circular linked list
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

        // Delete the head node
        System.out.println("After deleting 10 (head):");
        list.delete(10);
        list.display();

        // Delete all nodes
        System.out.println("Deleting remaining nodes:");
        list.delete(30);
        list.delete(40);
        list.display();
    }
}
