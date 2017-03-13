package tree.recursive;

/**
 * Created by abhijeetkedari on 3/11/17.
 */
public class TreeOperations {

    public static void main(String[] args){

        Tree tree = new Tree();

        Node root = null;

        root = tree.insert(root,90);
        root = tree.insert(root,80);
        root = tree.insert(root,95);
        root = tree.insert(root,77);
        //root = tree.insert(root,85);
        root = tree.insert(root,93);
        root = tree.insert(root,97);

        tree.BFS(root);
        System.out.println();
        tree.inorder(root);
        tree.delete(root,80);
        System.out.println("\nAfter deleting 90");
        tree.inorder(root);
        System.out.println();
        tree.BFS(root);

    }
}
