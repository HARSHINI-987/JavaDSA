package Tree;

class AVLNode {
    int key;
    int height;
    AVLNode left, right;

    AVLNode(int key) {
        this.key = key;
        this.height = 1; // Initial height of a new node is 1
    }
}
