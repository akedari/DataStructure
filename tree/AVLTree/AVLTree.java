package tree.AVLTree;

/**
 * Created by abhijeetkedari on 4/8/17.
 */
public class AVLTree {

    Node root;


    public Node insert(Node root, int data) {

        if(root==null){
            return new Node(data);
        }

        if(root.data<=data){
            root.right = insert(root.right,data);
        }
        else{
            root.left = insert(root.left,data);
        }

        int balance = balance(root.left, root.right);

        if(balance > 1){

            if(height(root.left.left)>=height(root.left.right)){
                root = rightRotate(root);
            }
            else{
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        }
        else if(balance < -1){
            if(height(root.right.right)>=height(root.right.left)){
                root = leftRotate(root);
            }
            else{
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }

        }
        else {
            root.height = setHeight(root);
            root.size = setSize(root);
        }

        return root;
    }

    private Node leftRotate(Node root) {
        Node newRoot =root.right;
        root.right = root.right.left;
        newRoot.left = root;

        root.height = setHeight(root);
        root.size = setSize(root);

        newRoot.height = setHeight(newRoot);
        newRoot.size = setSize(newRoot);

        return newRoot;
    }

    private Node rightRotate(Node root) {
        Node newRoot = root.left;
        root.left = root.left.right;
        newRoot.right = root;

        root.height = setHeight(root);
        root.size = setSize(root);

        newRoot.height = setHeight(newRoot);
        newRoot.size = setSize(newRoot);

        return newRoot;
    }

    private int setSize(Node root) {
        if(root==null){
            return 0;
        }
        else{
            return Math.max((root.left!=null? root.left.size:0 ),(root.right!=null? root.right.size:0)) + 1;
        }
    }

    private int setHeight(Node root) {
        if(root==null){
            return 0;
        }
        else{
            return Math.max( (root.left!=null? root.left.height:0) , (root.right!=null?root.right.height:0))+1;
        }

    }

    private int balance(Node left, Node right) {
        return height(left) - height(right);

    }

    private int height(Node root) {
        if(root == null){
            return 0;
        }
        else{
            return root.height;
        }
    }


    public void inorder(Node root) {
        if(root!=null){
            inorder(root.left);
            System.out.print(" "+root.data);
            inorder(root.right);
        }
    }

    public void preorder(Node root) {
        if(root!=null){
            System.out.print(" "+root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }
}
