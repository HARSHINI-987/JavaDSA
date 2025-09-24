package DS;
class NodeSC{
	int data;
	NodeSC next;
	NodeSC(int data){
		this.data=data;
		this.next=null;
	}
}
class SinglyCircular{
	NodeSC head=null;
	//Inserting in beginning
	void inBegin(int data) {
		NodeSC newNode=new NodeSC(data);
		if(head==null) {
			head=newNode;
			head.next=newNode;
			return;
		}
		NodeSC current=head;
		while(current.next!=head) {
			current=current.next;
		}
		current.next=newNode;
		newNode.next=head;
		head=newNode;
		return;
	}
	//Insert at end
	void atEnd(int data) {
		NodeSC newNode=new NodeSC(data);
		if(head==null) {
			head=newNode;
			head.next=newNode;
			return;
		}
		NodeSC current=head;
		while(current.next!=head) {
			current=current.next;
		}
		newNode.next=current.next;
		current.next=newNode;
	}
	//insert before a value
	void inBefore(int data,int val) {
		if(head==null) {
			System.out.println("LL is Empty");
			return;
		}
		if(head.data==val) {
			inBegin(data);
			return;
		}
		NodeSC current=head;
		while(current.next!=head && current.next.data!=val) {
			current=current.next;
		}
		if(current.next!=head && current.next.data==val) {
			NodeSC newNode=new NodeSC(data);
			newNode.next=current.next;
			current.next=newNode;
			return;
		}
		System.out.println("Searched value not in the LL");
	}
	void after(int data,int val) {
		if(head==null) {
			System.out.println("LL is Empty");
			return;
		}
		NodeSC current=head;
		while(current.next!=head && current.data!=val) {
			current=current.next;
		}
		if(current.data==val) {
			NodeSC newNode=new NodeSC(data);
			newNode.next=current.next;
			current.next=newNode;
			return;
		}
		System.out.println("Searched value not in the LL");
	}
	void print() {
		if(head==null) {
			System.out.println("Empty LL");
			return;
		}
		NodeSC current=head;
		while(current.next!=head) {
			System.out.print(current.data+" --->");
			current=current.next;
		}
		System.out.println(current.data+" ---> Head");
	}
	void delete(int key) {
		if(head==null) {
			System.out.println("LL is Empty");
			return;
		}
		NodeSC current=head;
		if(head.data==key) {
			if(head.next==head) {
				head=null;
				return;
			}
			while(current.next!=head) {
				current=current.next;
			}
			current.next=head.next;
			head=head.next;
			return;
		}
		while(current.next!=head&&current.next.data!=key) {
			current=current.next;
		}
		if(current.next!=head&&current.next.data==key) {
			current.next=current.next.next;
			return;
		}
		System.out.println("Key is not in the list");
	}
}



public class LLDriver {
	public static void main(String[] args) {
		SinglyCircular scl=new SinglyCircular();
		scl.inBegin(2);
		scl.inBegin(1);
		scl.atEnd(5);
		scl.atEnd(6);
		scl.print();
		scl.inBefore(0, 1);
		scl.inBefore(7, 6);
		scl.inBefore(8, 9);
		scl.print();
		scl.after(8, 6);
		scl.after(1, 0);
		scl.print();
		scl.delete(1);
		scl.print();
		scl.delete(0);
		scl.print();
		scl.delete(8);
		scl.print();
		scl.delete(7);
		scl.delete(6);
		scl.delete(5);
		scl.delete(2);
		scl.print();
		scl.delete(1);
		scl.print();
}
}
