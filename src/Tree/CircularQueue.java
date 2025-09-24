package Tree;

class CircularQueue {
    private NodeTree[] arr;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new NodeTree[capacity];
        front = size = 0;
        rear = -1;
    }

    // Check if the Queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the Queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // EnCircularQueue (Insert at rear)
    public void enQueue(NodeTree address) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = address;
        size++;
    }

    // DeCircularQueue (Remove from front)
    public NodeTree deQueue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return null;
        }
        NodeTree temp = arr[front];
        front = (front + 1) % capacity;
        size--;
        return temp;
    }
}
