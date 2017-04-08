package tree.AVLTree;

/**
 * Created by abhijeetkedari on 4/8/17.
 */
public class Node {

    int data;
    int height;
    int size;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.height = 1;
        this.size = 1;
        this.left = null;
        this.right = null;
    }

    public Node(int data, int height, int size, Node left, Node right) {
        this.data = data;
        this.height = height;
        this.size = size;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
