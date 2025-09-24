package DS;

public class QueueDriver {
	public static void main(String[] args) {
		QueueInt q=new QueueInt(5);
		q.enque(10);
		q.enque(20);
		q.enque(30);
		q.enque(40);
		q.enque(50);
		q.enque(60);
		int dq;
		dq=q.dequeue();
		System.out.println((dq==Integer.MIN_VALUE)? "":dq);
		dq=q.dequeue();
		System.out.println((dq==Integer.MIN_VALUE)? "":dq);
		dq=q.dequeue();
		System.out.println((dq==Integer.MIN_VALUE)? "":dq);
		dq=q.dequeue();
		System.out.println((dq==Integer.MIN_VALUE)? "":dq);
		dq=q.dequeue();
		System.out.println((dq==Integer.MIN_VALUE)? "":dq);
		dq=q.dequeue();
		System.out.println((dq==Integer.MIN_VALUE)? "":dq);
	}
}
