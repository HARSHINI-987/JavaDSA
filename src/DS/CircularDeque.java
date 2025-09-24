package DS;
class CircularDeque {
    private int[] arr; // Array to store elements
    private int front; // Front pointer
    private int rear;  // Rear pointer
    private int size;  // Current size of the deque
    private int capacity; // Maximum capacity of the deque

    // Constructor to initialize the deque
    public CircularDeque(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1; // Initially, the deque is empty
        rear = -1;  // Initially, the deque is empty
        size = 0;
    }

    // Check if the deque is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Insert an element at the front
    public void insertFront(int data) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert at the front.");
            return;
        }

        if (isEmpty()) { // First element to be inserted
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        arr[front] = data;
        size++;
        System.out.println(data + " inserted at front");
    }

    // Insert an element at the rear
    public void insertRear(int data) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert at the rear.");
            return;
        }

        if (isEmpty()) { // First element to be inserted
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        arr[rear] = data;
        size++;
        System.out.println(data + " inserted at rear");
    }

    // Delete an element from the front
    public int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from the front.");
            return Integer.MIN_VALUE;
        }

        int data = arr[front];

        if (front == rear) { // Single element remaining
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        size--;
        System.out.println(data + " deleted from front");
        return data;
    }

    // Delete an element from the rear
    public int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from the rear.");
            return Integer.MIN_VALUE;
        }

        int data = arr[rear];

        if (front == rear) { // Single element remaining
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }

        size--;
        System.out.println(data + " deleted from rear");
        return data;
    }

    // Get the front element
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    // Get the rear element
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return Integer.MIN_VALUE;
        }
        return arr[rear];
    }

    // Display all elements in the deque
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        System.out.print("Elements in deque: ");
        int i = front;
        do {
            System.out.print(arr[i] + " ");
            i = (i + 1) % capacity; // Move to the next index circularly
        } while (i != (rear + 1) % capacity);
        System.out.println();
    }
}