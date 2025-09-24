package DS;

public class SinglyDriver {
	public static void main(String[] args) {
		SinglyLinkedList sll=new SinglyLinkedList();
		sll.inBegin(5);
		sll.inBegin(7);
		sll.display();
		sll.atEnd(17);
		sll.atEnd(27);
		sll.display();
		sll.inPos(2,8);
		sll.inPos(3,18);
		sll.display();
		sll.inPos(10, 25);
		sll.search(27);
		sll.search(100);
		sll.delete(25);
		sll.display();
		sll.search(27);
		sll.bubbleSort();
		sll.display();
	}
}
