package DS;
class NodeDll {
    int data;
    NodeDll prev;
    NodeDll next;
    NodeDll(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    NodeDll head=null;
    void inBegin(int data) {
        NodeDll newNode = new NodeDll(data);
        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    void print() {
        NodeDll current = head;
        if(head==null) {
        	System.out.println("LL is Empty");
        	return;
        }
        while (current.next != null) {
                System.out.print(current.data + " <---> ");
                current = current.next;
            }
        System.out.print(current.data);
    }
    void atEnd(int data) {
    	NodeDll newNode=new NodeDll(data);
    	if(head==null) {
    		head=newNode;
    		return;
    	}
    	NodeDll current=head;
    	while(current.next!=null) {
    		current=current.next;
    	}
    	newNode.prev=current;
    	current.next=newNode;
    }
}

public class DLLDriver {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.inBegin(6);
        dll.inBegin(5);
        dll.inBegin(4);
        dll.atEnd(9);
        dll.print();
    }
}
