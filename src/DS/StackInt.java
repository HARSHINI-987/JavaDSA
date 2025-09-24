	package DS;
	class StackInt {
	    private int[] arr; // Array to hold stack elements
	    private int top;    // Index of the top element
	    private int size;   // Maximum size of the stack
	
	    // Constructor
	    public StackInt(int size) {
	        this.size = size;
	        arr = new int[size];
	        top = -1; // Stack is initially empty
	    }
	
	    // Push an element onto the stack
	    public void push(int num) {
	        if (top == size - 1) {
	            System.out.println("Stack Overflow");
	            return;
	        }
	        arr[++top] =num;
	    }
	
	    // Pop an element from the stack
	    public int pop() {
	        if (top == -1) {
	            System.out.println("Stack Underflow");
	            return -1; // Return if stack is empty
	        }
	        return arr[top--];
	    }
	
	    // Peek at the top element of the stack
	    public int peek() {
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
	
