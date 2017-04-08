package tree.AVLTree;

/**
 * Created by abhijeetkedari on 4/8/17.
 */
public class AVLTreeMain {

    public static void main(String[] args){

        AVLTree tree =  new AVLTree();
        Node root =null;

        root = tree.insert(root,-10);
        root = tree.insert(root,2);
        root = tree.insert(root,13);
        root = tree.insert(root,-13);
        root = tree.insert(root,-15);
        root = tree.insert(root,15);
        root = tree.insert(root,17);
        root = tree.insert(root,20);

        //TestCase
//        root = tree.insert(root,14);
//        root = tree.insert(root,17);
//        root = tree.insert(root,11);
//        root = tree.insert(root,7);
//        root = tree.insert(root,53);
//        root = tree.insert(root,4);
//        root = tree.insert(root,13);
//        root = tree.insert(root,12);
//        root = tree.insert(root,8);
//        4 7 8 11 12 13 14 17 53   inorder
//        14 11 7 4 8 12 13 17 53   preorder

        tree.inorder(root);
        System.out.println();
        tree.preorder(root);

    }
}
