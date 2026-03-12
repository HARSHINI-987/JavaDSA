package tree;
import java.util.Queue;
import java.util.LinkedList;
//Node Creation
class Node{
	int data;
	Node right;
	Node left;
	Node(int data){
		this.data=data;
	}
}
//Tree Method Class
class BinaryTree{
	Node root;
	//Insert
	void insert(int data) {
		Node newNode=new Node(data);
		if(root==null) {
			root=newNode;
			return;
		}
		Queue<Node> q=new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			Node current=q.poll();
			if(current.left==null) {
				current.left=newNode;
				return;
			}
			else {
				q.offer(current.left);
			}
			if(current.right==null) {
				current.right=newNode;
				return;
			}
			else {
				q.offer(current.right);
			}
		}
	}
	//Level order
	void levelOrder(Node root) {
		Queue<Node> q=new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			Node current=q.poll();
			if(current.left!=null) {
				q.offer(current.left);
			}
			if(current.right!=null) {
				q.offer(current.right);
			}
			System.out.print(current.data+" ");
		}
	}
	void levelOrder() {
		if(root==null) {
			System.out.println("Empty Tree");
			return;
		}
		System.out.println("Level Order");
		levelOrder(root);
	}
	//Delete
	void delete(int val) {
		if(root==null) {
			System.out.println("Can't delete");
			return;
		}
		Queue<Node> q=new LinkedList<>();
		q.offer(root);
		Node keyNode=null;
		Node parent=null;
		Node current=null;
		while(!q.isEmpty()) {
			current=q.poll();
			if(current.data==val) {
				keyNode=current;
			}
			if(current.left!=null) {
				q.offer(current.left);
				parent=current;
			}
			if(current.right!=null) {
				q.offer(current.right);
				parent=current;
			}
		}
		if(keyNode==null) {
			System.out.println("Not available");
			return;
		}
		keyNode.data=current.data;
		if(parent.right==current) {
			parent.right=null;
			return;
		}
		parent.left=null;		
	}
	//Height
	public void height() {
    	System.out.println("Height : "+height(root));
    }
    public int height(Node node) {
        if (node == null) 
        	return -1;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    //Inorder
    void inOrder(Node root) {
    	if(root!=null) {
    		inOrder(root.left);
    		System.out.print(root.data+" ");
    		inOrder(root.right);
    	}
    }
    void inOrder() {
    	if(root==null) {
    		System.out.println("Empty");
    		return;
    	}
    	System.out.println("InOrder");
    	inOrder(root);
    }
    //PreOrder
    void preOrder(Node root) {
    	if(root!=null) {
    		System.out.print(root.data+" ");
    		preOrder(root.left);
    		preOrder(root.right);
    	}
    }
    void preOrder() {
    	if(root==null) {
    		System.out.println("Empty");
    		return;
    	}
    	System.out.println("PreOrder");
    	preOrder(root);
    }
    //postorder
    void postOrder(Node root) {
    	if(root!=null) {
    		postOrder(root.left);
    		postOrder(root.right);
    		System.out.print(root.data+" ");
    	}
    }
    void postOrder() {
    	if(root==null) {
    		System.out.println("Empty");
    		return;
    	}
    	System.out.println("PostOrder");
    	postOrder(root);
    }
}
public class BinaryTreeDriver {
	public static void main(String[] args) {
		BinaryTree b=new BinaryTree();
		b.insert(5);
		b.insert(8);
		b.insert(9);
		b.insert(7);
		b.insert(3);
		b.insert(4);
		b.insert(1);
		b.levelOrder();
		System.out.println();
		b.postOrder();
		System.out.println();
		b.preOrder();
		System.out.println();
		b.inOrder();
		System.out.println();
		b.height();
		b.delete(7);
		b.levelOrder();
		System.out.println();
	}
}
