package DS;

public class QueueInt {
	int front;
	int rear;
	int arr[];
	int capacity;
	QueueInt(int capacity){
		arr=new int[capacity];
		front=-1;
		rear=-1;
		this.capacity=capacity;
	}
	boolean isEmpty() {
		if((rear==-1 && front==-1)|| (front>rear)) {
			return true;
		}
		return false;
	}
	boolean isFull() {
		if(front==0&&rear==capacity-1) {
			return true;
		}
		return false;
	}
	void enque(int data) {
		if(rear==capacity-1) {
			System.out.println("Overflow");
			return;
		}
		if(front ==-1) {
			front=0;
		}
		arr[++rear]=data;
	}
	int dequeue() {
		if(front ==-1) {
			return Integer.MIN_VALUE;
		}
		int element=arr[front];
		if(++front>rear) {
			front=-1;
			rear=-1;
		}
		 return element;
	}
	int peek() {
		if(front ==-1) {
			System.out.println("Underflow");
			return Integer.MIN_VALUE;
		}
		 return arr[front];
	}
}


