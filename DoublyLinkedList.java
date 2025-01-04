
public class DoublyLinkedList {
   
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    private Node head; 
    
    // Method to insert a node at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next; 
            }
            temp.next = newNode;  
            newNode.prev = temp; 
        }
    }

    // Method to display the doubly linked list
    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
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
        Node temp = head;
        if (temp.data == key) {
            head = head.next; 
            if (head != null) {
                head.prev = null; 
            }
            return;
        }

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        
        if (temp == null) {
            System.out.println("Value " + key + " not found in the list.");
            return;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev; 
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next; 
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Insert elements into the doubly linked list
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

        // Delete the tail node
        System.out.println("After deleting 40 (tail):");
        list.delete(40);
        list.display();

        // Delete the remaining node
        System.out.println("After deleting 30:");
        list.delete(30);
        list.display();
    }
}
