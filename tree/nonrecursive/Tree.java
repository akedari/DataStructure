package tree.nonrecursive;


import java.util.Stack;

/**
 * Created by abhijeetkedari on 3/12/17.
 */

class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Tree {
    Node root = null;

    public Node insert(Node root, int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return root;
        } else {
            Node temp = root;

            while (true) {
                if (data <= temp.data) {
                    if (temp.left != null) {
                        temp = temp.left;
                    } else {
                        temp.left = newNode;
                        return root;
                    }
                } else {
                    if (temp.right != null) {
                        temp = temp.right;
                    } else {
                        temp.right = newNode;
                        return root;
                    }
                }
            }
        }
    }

    public Node deleteNode(Node root, int data) {

        Node current = root;
        Node parent = current;
        boolean isLeftChild = false;

        while (current.data != data) {
            parent = current;
            if (current.data < data) {
                current = current.right;
                isLeftChild = false;

            } else {
                current = current.left;
                isLeftChild = true;
            }
            if (current == null) {
                System.out.print("No data found !!!");
                return root;
            }
        }

        //no child case
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            return root;
        }//end of if

        //one child case
        if(current.left==null){
            if(current==root){
                root=root.right;
            }
            else if (isLeftChild){
                parent.left = current.right;
            }
            else {
                parent.right =current.right;
            }
            return root;

        }
        if(current.right ==null){
            if(current==root){
                root=root.left;
            }
            else if(isLeftChild){
                parent.left = current.left;
            }
            else {
                parent.right = current.left;
            }
            return root;
        }


        //two child case
        if(current.left!=null && current.right!=null){
            Node successor = getSuccessor(current);

            if(current==root){
                root  =successor;
            }
            successor.left = current.left;
            if(isLeftChild){
                parent.left = successor;
            }
            else {
                parent.right =successor;
            }
            return root;
        }


        return root;
    }

    private Node getSuccessor(Node current) {
        Node successor = null;
        Node successorsParent =null;
        Node deleteNode = current;

        Node temp = current.right;

        while(temp!=null){
            successorsParent =successor;
            successor =temp;
            temp =temp.left;
        }
        if(successor==deleteNode.right){
            return successor;
        }
        else{
            successorsParent.left = successor.right;
            successor.right = deleteNode.right;
        }

        return successor;
    }


    public void dfs_preorder(Node root){
        if(root==null){

            System.out.println(" Empty Tree !!!");
        }
        else{

            Stack<Node> st = new Stack<>();
            st.push(root);
            Node current = root;


            while(!st.isEmpty()){
                Node temp = st.pop();
                System.out.print(" "+temp.data);

                if(temp.right!=null){
                    st.push(temp.right);
                }
                if(temp.left!=null){
                    st.push(temp.left);
                }

            }
        }
    }

    public void dfs_inorder(Node root){

        Stack<Node> sti = new Stack<>();
        Node current =  root;

        while(!sti.isEmpty() || current!=null){

            if(current!=null){
                sti.push(current);
                current=current.left;
            }
            else{
                Node temp  = sti.pop();
                System.out.print(" "+ temp.data);
                current = temp.right;
            }

        }
    }


}
