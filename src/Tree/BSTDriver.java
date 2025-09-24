package Tree;

public class BSTDriver {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insertUsingStack(40);
        tree.insert(60);
        tree.insert(80);

        tree.inOrder();   
        tree.preOrder();  
        tree.postOrder(); 

        System.out.println("\nHeight of the tree: " + tree.height());

        System.out.println("Height of node 50: " + tree.height(tree.root));
        System.out.println("Height of node 30: " + tree.height(tree.root.left));
        System.out.println("Height of node 70: " + tree.height(tree.root.right));
    }
}

