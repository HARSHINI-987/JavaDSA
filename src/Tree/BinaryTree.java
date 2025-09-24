package Tree;
import java.util.*;

public class BinaryTree {
    NodeTree root;
    private static final int MAX_NODE= 100; // Max size of the CircularQueue

    // Insert NodeTree in Binary Tree (Level Order)
    public void insert(int key) {
        NodeTree newNode = new NodeTree(key);
        if (root == null) {
            root = newNode;
            return;
        }
        Deque<NodeTree> q=new LinkedList<>();
        CircularQueue queue = new CircularQueue(MAX_NODE);
        queue.enQueue(root);

        while (!queue.isEmpty()) {
            NodeTree temp = queue.deQueue();
            // Insert in left child if empty
            if (temp.left == null) {
                temp.left = newNode;
                return;
            } else {
                queue.enQueue(temp.left);
            }
            // Insert in right child if empty
            if (temp.right == null) {
                temp.right = newNode;
                return;
            } else {
                queue.enQueue(temp.right);
            }
        }
    }

    // Delete a NodeTree in Binary Tree
    public void delete(int key) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        CircularQueue queue = new CircularQueue(MAX_NODE);
        queue.enQueue(root);
        NodeTree keyNode = null, temp = null, parent = null;
        // Search for the NodeTree to be deleted and the last NodeTree
        while (!queue.isEmpty()) {
            temp = queue.deQueue();
            if (temp.data == key) {
                keyNode = temp;
            }
            if (temp.left != null) {
                parent = temp;
                queue.enQueue(temp.left);
            }
            if (temp.right != null) {
                parent = temp;
                queue.enQueue(temp.right);
            }
        }

        // If the key is not found
        if (keyNode == null) {
            System.out.println("Key not found in tree");
            return;
        }

        // Replace keyNodeTree with the deepest NodeTree
        keyNode.data = temp.data;

        // Delete the deepest NodeTree
        if (parent.right == temp) {
            parent.right = null;
        } else {
            parent.left = null;
        }
    }

    // In-order Traversal (Left, Root, Right)
    public void inOrder(NodeTree root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
    public void inOrder() {
        System.out.print("In-order: ");
        inOrder(root);
        System.out.println();
    }

    // Pre-order Traversal (Root, Left, Right)
    public void preOrder(NodeTree root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void preOrder() {
        System.out.print("Pre-order: ");
        preOrder(root);
        System.out.println();
    }

    // Post-order Traversal (Left, Right, Root)
    public void postOrder(NodeTree root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void postOrder() {
        System.out.print("Post-order: ");
        postOrder(root);
        System.out.println();
    }
}

