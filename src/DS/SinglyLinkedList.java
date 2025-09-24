package DS;

class SinglyLinkedList {
	NodeSll head=null;
	
	//insert in begining
	void inBegin(int data) {
		NodeSll newNode=new NodeSll(data);
		if(head==null) {
			head=newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
		return;
	}
	
	
	//insert at end
	void atEnd(int data) {
		if(head==null) {
			inBegin(data);
			return;
		}
		NodeSll current=head;
		while(current.next!=null) {
			current = current.next;
		}
		NodeSll newNode=new NodeSll(data);
		current.next=newNode;
	}
	
	//insert by position
	
	void inPos(int pos,int data) {
		if(head==null||pos==0) {
			if(pos==0) {
				inBegin(data);
				return;
			}
			System.out.println("Index Out of bound");
			return;
		}
		NodeSll current=head;
		int cp=1;
		while(current!=null && cp!=pos) {
			current=current.next;
			cp++;
		}
		if(current!=null && pos==cp) {
			NodeSll newNode=new NodeSll(data);
			newNode.next=current.next;
			current.next=newNode;
			return;
		}
		System.out.println("Out of Bound");
		return;
	}
	
	//Deletion
	void delete(int val) {
		if(head==null) {
			System.out.println("Deletion cant Perform");
			return;
		}
		if(head.data==val) {
			head=head.next;
			return;
		}
		NodeSll current=head;
		while(current.next!=null && current.next.data!=val) {
			current=current.next;
		}
		if(current.next!=null &&current.next.data==val) {
			current.next=current.next.next;
			return;
		}
		System.out.println("Value Not in the List");
		return;
	}
	
	
   //Searching
	void search(int val) {
		if(head==null) {
			System.out.println("LL is Empty deletion can't Seaerch");
			return;
		}
		NodeSll current=head;
		int ind=0;
		while(current!=null) {
			if(current.data==val) {
				System.out.println(val+" is in position "+ind);
				return;
			}
			ind++;
			current=current.next;
		}
		System.out.println(val +" is not in the list");
	}
	
	// Sorting LL by bubble sort
			void bubbleSort() {
				if(head ==null) {
					return;
				}
				NodeSll current=head;
				boolean flag=true;
				while(flag) {
					flag=false;
					while(current.next!=null) {
						if(current.data>current.next.data) {
							int temp=current.data;
							current.data=current.next.data;
							current.next.data=temp;
							flag=true;
						}
						current=current.next;
					}
					current=head;
				}
			}
			
	
	//display
	void display() {
		if(head==null) {
			System.out.println("Empty LL");
			return;
		}
		NodeSll current=head;
		while(current.next!=null) {
			System.out.print(current.data+" --> ");
			current =current.next;
		}
		System.out.println(current.data);
	}	
}
