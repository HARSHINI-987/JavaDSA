package DS;

public class CircularDequeDriver {
    public static void main(String[] args) {
        CircularDeque deque = new CircularDeque(5); // Deque with capacity 5

        // Test operations
        deque.insertRear(10);
        deque.insertRear(20);
        deque.insertFront(5);
        deque.insertFront(2);
        deque.insertRear(30); // Deque is now full

        deque.display(); // Output: Elements in deque: 2 5 10 20 30

        deque.deleteFront(); // Removes 2
        deque.deleteRear();  // Removes 30

        deque.display(); // Output: Elements in deque: 5 10 20

        deque.insertFront(50); // Add 50 at the front
        deque.insertRear(60);  // Add 60 at the rear

        deque.display(); // Output: Elements in deque: 50 5 10 20 60
    }
}
