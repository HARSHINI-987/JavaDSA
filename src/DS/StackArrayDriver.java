package DS;

class StackArray {
    int capacity = 5; // Maximum capacity of the stack
    int top = -1; // Indicates the top of the stack
    int arr[] = new int[capacity]; // Array to hold the stack elements

    // Method to push data onto the stack
    void push(int data) {
        if (top < capacity - 1) {
            arr[++top] = data;
            System.out.println(data + " Pushed in stack");
        } else {
            System.out.println("Stack Overflow");
        }
    }

    // Method to pop data from the stack
    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        return arr[top--];
    }
    
    int peek() {
    	if(top==-1) {
            throw new IllegalStateException("Stack Overflow");
    	}
    	return arr[top];
    }
}

public class StackArrayDriver {
    public static void main(String[] args) {
        StackArray s = new StackArray();

        // Push elements onto the stack
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6); // This will trigger "Stack Overflow"

        // Pop elements from the stack
        int poppedElement = s.pop();
        if (poppedElement == Integer.MIN_VALUE) {
            System.out.println("Under Flow");
        } else {
            System.out.println("Popped element: " + poppedElement);
        }

        // Pop another element
        poppedElement = s.pop();
        if (poppedElement == Integer.MIN_VALUE) {
            System.out.println("Under Flow");
        } else {
            System.out.println("Popped element: " + poppedElement);
        }
    }
}
