import java.util.Scanner;

public class stack {
    int top = -1; // Keeps track of the top index

    // Push operation
    public void push(int[] arr, int val) {
        if (top + 1 == arr.length) {
            System.out.println("Can't add more value! Overflow.");
            return;
        }
        top += 1;
        arr[top] = val;
        System.out.println("Pushed " + val + " to the stack.");
    }

    // Display operation
    public void display(int[] arr) {
        if (top == -1) {
            System.out.println("The stack is empty.");
            return;
        }
        System.out.println("Stack elements:");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    // Pop operation
    public void pop(int[] arr) {
        if (top == -1) {
            System.out.println("The stack is already empty! Underflow.");
            return;
        }
        int x = arr[top];
        top -= 1;
        System.out.println("Popped element from the stack: " + x);
    }

    public void change(int[] arr,int idx ,int value){
        if(idx > top || idx > arr.length || idx < 0){
            System.out.println("element or index doesn't exist, enter valid idx");
        }
        
        arr[idx] = value;
        System.out.println("changes successfully !!");  
    }

    public static void main(String[] args) {
        int[] arr = new int[5]; 
        stack call = new stack(); 
        Scanner choice = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1) Push\n2) Display\n3) Pop\n4) Change\n5)Exit");
            int userChoice = choice.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Enter the value that you want to push:");
                    int val = choice.nextInt();
                    call.push(arr, val);
                    break;
                case 2:
                    call.display(arr);
                    break;
                case 3:
                    call.pop(arr);
                    break;
                case 4:
                    System.out.println("Enter the index that you want to change:");
                    int idx = choice.nextInt();
                    System.out.println("Enter the index that you want to replace with:");
                    int value = choice.nextInt();
                    call.change(arr, idx ,value);
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    choice.close(); // Close scanner before exiting
                    return;
                default:
                    System.out.println("Enter a valid choice.");
            }
        }
    }
}
