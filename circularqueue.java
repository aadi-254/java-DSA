import java.util.*;

public class circularqueue {
    int front = -1;
    int rear = -1;

    public void enqueue(int[] arr, int val) {
        // Overflow condition
        if ((rear == arr.length - 1 && front == 0) || (rear + 1 == front)) {
            System.out.println("Overflow! Queue is full.");
            return;
        }

        // First element insertion
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else if (rear == arr.length - 1) { // Wrap around rear
            rear = 0;
        } else {
            rear++;
        }

        arr[rear] = val;
        System.out.println("Enqueued: " + val);
    }

    public void dequeue(int[] arr) {
        // Underflow condition
        if (front == -1) {
            System.out.println("Underflow! Queue is empty.");
            return;
        }

        System.out.println("Dequeued: " + arr[front]);

        // Single element case
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == arr.length - 1) { // Wrap around front
            front = 0;
        } else {
            front++;
        }
    }

    public void display(int[] arr) {
        // Empty queue case
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        if (rear >= front) {
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            for (int i = front; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        circularqueue cq = new circularqueue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter your choice:\n1) Enqueue\n2) Dequeue\n3) Display\n4) Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter a value to enqueue:");
                    int val = scanner.nextInt();
                    cq.enqueue(arr, val);
                    break;
                case 2:
                    cq.dequeue(arr);
                    break;
                case 3:
                    cq.display(arr);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Enter a valid choice.");
            }
        }
    }
}
