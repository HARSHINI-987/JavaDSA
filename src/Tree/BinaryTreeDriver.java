package Tree;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert NodeTrees in Level Order
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        // Print tree traversals
        tree.inOrder();   // Expected: 4 2 5 1 6 3 7
        tree.preOrder();  // Expected: 1 2 4 5 3 6 7
        tree.postOrder(); // Expected: 4 5 2 6 7 3 1

        // Delete a NodeTree and print traversals again
        System.out.println("\nDeleting 3...");
        tree.delete(3);

        tree.inOrder();   // Expected: 4 2 5 1 6 7
        tree.preOrder();  // Expected: 1 2 4 5 7 6
        tree.postOrder(); // Expected: 4 5 2 6 7 1
    }
}

