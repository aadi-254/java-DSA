import java.util.*;

public class doublyqueue {
    int front, rear = -1;

    public void insertFront(int[] arr, int val) {
        if (front == 0) { // Overflow condition
            System.out.println("Overflow at the front");
            return;
        }

        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else {
            front--;
        }

        arr[front] = val;
    }

    public void insertRear(int[] arr, int val1) {
        if (rear == arr.length - 1) {
            System.out.println("overflow");
        } else if (front == -1 || rear == -1) {
            front = 0;
            rear = 0;
        } else {
            rear += 1;
        }

        arr[rear] = val1;
    }

    public void deleteFront(int[] arr) {
        if (front == -1) {
            System.out.println("underflow");
            return;
        }
        if (front == rear) {
            System.out.println("deleted from front !");
            front = -1;
            rear = -1;
            return;
        } else {
            front += 1;
        }
        System.out.println("deleted from front !" );

    }

    public void deleteRear(int[] arr) {
        if (rear == -1) { // Underflow condition
            System.out.println("Underflow at the rear");
            return;
        }

        System.out.println("Deleted from rear: " + arr[rear]);

        if (front == rear) { 
            front = -1;
            rear = -1;
        } else {
            rear--;
        }

    }

    public void display(int[] arr) {
        if (front == -1) { // Queue is empty
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) { // Linear iteration from front to rear
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
    

    public static void main(String[] args) {

        int[] arr = new int[5];

        doublyqueue call = new doublyqueue();
        Scanner choice = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "\nenter your choice :\n 1)insertFront\n2)insertRear\n3)deleteFront\n4)deleteRear\n5)display\n6)exit");
            int userinput = choice.nextInt();

            switch (userinput) {
                case 1:
                    System.out.println("enter a value that you want to insert");
                    int val = choice.nextInt();
                    call.insertFront(arr, val);
                    break;
                case 2:
                    System.out.println("enter a value that you want to insert");
                    int val1 = choice.nextInt();
                    call.insertRear(arr, val1);
                    break;
                case 3:
                    call.deleteFront(arr);
                    break;
                case 4:
                    call.deleteRear(arr);
                    break;
                case 5:
                    call.display(arr);
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    choice.close();
                    return;
                default:
                    System.out.println("enter a valid choice");
            }
        }
    }
}
