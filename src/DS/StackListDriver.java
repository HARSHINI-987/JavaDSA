package DS;
class NodeStack{
	int data;
	NodeStack next;
	NodeStack(int data){
		this.data=data;
		this.next=null;
	}
}
class StackList{
	NodeStack top=null;
	void push(int data) {
		NodeStack newNode=new NodeStack(data);
		newNode.next=top;
		top=newNode;
		}
	void pop() {
		System.out.println(top.data);
		top=top.next;
	}
	void peek() {
		System.out.println(top.data);
	}
	void display() {
		NodeStack temp=top;
		if(temp==null) {
			System.out.println("Empty");
			return;
		}
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
}
public class StackListDriver {
	public static void main(String[] args) {
	StackList sl=new StackList();
	sl.push(10);
	sl.push(20);
	sl.push(10);
	sl.push(10);
	sl.pop();
	sl.pop();
	sl.display();
	}
	
}
