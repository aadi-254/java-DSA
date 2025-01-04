import java.util.Scanner;

public class queue {
    int rear = -1;
    int front = -1;

    // Enqueue operation
    public void enqueue(int[] arr, int val) {
        if (rear == arr.length - 1) {
            System.out.println("Overflow! Cannot enqueue more elements.");
            return;
        }
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else {
            rear += 1;
        }
        arr[rear] = val;
        System.out.println("Enqueued: " + val);
    }

    // Dequeue operation
    public void dequeue(int[] arr) {
        if (front == -1 || front > rear) {
            System.out.println("Underflow! The queue is empty.");
            return;
        }
        System.out.println("Dequeued element: " + arr[front]);
        front += 1; 

      
        if (front > rear) {
            front = -1;
            rear = -1;
        }
    }

    // Display operation
    public void display(int[] arr) {
        if (front == -1) {
            System.out.println("The queue is empty.");
            return;
        }
        System.out.println("Queue elements:");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        queue call = new queue();
        Scanner choice = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1) Enqueue\n2) Dequeue\n3) Display\n4) Exit");
            int userChoice = choice.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Enter the value that you want to enqueue:");
                    int val = choice.nextInt();
                    call.enqueue(arr, val);
                    break;
                case 2:
                    call.dequeue(arr);
                    break;
                case 3:
                    call.display(arr);
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    choice.close(); 
                    return;
                default:
                    System.out.println("Enter a valid choice.");
            }
        }
    }
}
