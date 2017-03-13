package tree.nonrecursive;

/**
 * Created by abhijeetkedari on 3/12/17.
 */
public class TreeOperations {

        public static void main(String[] args) {

            Tree tree = new Tree();

            Node root = null;

            root = tree.insert(root,90);
            root = tree.insert(root,80);
            root = tree.insert(root,95);
            root = tree.insert(root,77);
            root = tree.insert(root,85);
            root = tree.insert(root,93);
            root = tree.insert(root,97);
            root = tree.insert(root,97);
            System.out.println("\nPreOrder");
            tree.dfs_preorder(root);
            System.out.println("\nInorder");
            tree.dfs_inorder(root);

            System.out.println("\ndeleting 95");
            tree.deleteNode(root,95);
            System.out.println("\nPreOrder");
            tree.dfs_preorder(root);
            System.out.println("\nInorder");
            tree.dfs_inorder(root);





        }
}
