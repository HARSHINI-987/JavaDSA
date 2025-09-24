package DS;

class StackChar {
    private char[] arr; // Array to hold stack elements
    private int top;    // Index of the top element
    private int size;   // Maximum size of the stack

    // Constructor
    public StackChar(int size) {
        this.size = size;
        arr = new char[size];
        top = -1; // Stack is initially empty
    }

    // Push an element onto the stack
    public void push(char ch) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = ch;
    }

    // Pop an element from the stack
    public char pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return '\0'; // Return null character if stack is empty
        }
        return arr[top--];
    }

    // Peek at the top element of the stack
    public char peek() {
        if (top == -1) {
            return '\0'; // Return null character if stack is empty
        }
        return arr[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}
