package tree.recursive;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by abhijeetkedari on 3/11/17.
 */


class Node {

    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data=data;
        this.left = null;
        this.right=null;
    }

}
public class Tree {

    Node root=null;

    private Node getNewNode(int data){
        Node newNode = new Node(data);
        return newNode;
    }

    private void deleteNode(Node node){
        node =null;
    }

    public Node insert(Node root, int data){

        if(root==null){
            root = getNewNode(data);
            return root;
        }
        else if(data<=root.data){
            root.left = insert(root.left,data);
            return root;
        }
        else{
            root.right = insert(root.right,data);
            return root;
        }
    }


    public void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(" "+root.data);
            inorder(root.right);
        }
    }

    public void preorder(Node root){
        if(root!=null){
            System.out.print(" "+root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(" "+root.data);
        }
    }

    public void BFS(Node root){

        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);

        while(!queue.isEmpty()){

            Node node = queue.remove();
            System.out.print(" "+node.data);

            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }

        }

    }



    public Node delete(Node root, int data){

        if(root==null){
            return null;
        }
        else if(data<root.data){
            if(root.left!=null){
                root.left = delete(root.left,data);
            }
            else {
                System.out.print("No valid data found !!!");
            }
        }
        else if(data>root.data){
            if(root.right!=null){
                root.right = delete(root.right,data);
            }
            else {
                System.out.print("No valid data found !!!");
            }
        }
        else{

            // no child
            if(root.left == null && root.right==null){
//                deleteNode(root);
                return null;
            }

            //one child
            else if(root.left ==null){
                Node temp = root;
                root = root.right;
//                deleteNode(temp);
            }

            else if(root.right ==null){
                Node temp = root;
                root = root.left;
//                deleteNode(temp);
            }

            // two children
            else{
                Node min = findMinNode(root.right);
                root.data = min.data;
                root.right = delete(root.right,min.data);
            }

        }
        return root;
    }

    private Node findMinNode(Node node) {
        if(node==null){
            return null;
        }
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }

}
