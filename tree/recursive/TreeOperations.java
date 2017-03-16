package tree.recursive;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by abhijeetkedari on 3/11/17.
 */
public class TreeOperations {

    public static void main(String[] args){

        Tree tree = new Tree();
        Node root = null;

        int[] array = {1,2,3,4,5,6,7,8,9};
        root = createBSTwithMinHeightFromSortedArray(array,array.length);

//        checkforBalancedTree(tree,root);
//        treeTravsersalMethods(tree,root);

//        ArrayList<LinkedList<Node>> result = createLevelwiseLists();
//        displayLevelWiseNodes(result);

//        int data = 10;   //node whose Inorder successor we are looking for.
//        findInorderSuccesor(root,data);
        
//        findCommonAncestor(root,4,1);

//        int sum =7;
//        System.out.println("\nAll possible paths");
//        findAllpaths(root);
//        System.out.println("\nAll possible paths with Sum = "+sum);
//        findSum(root,sum);

        Node root2 = null;
        int[] array2 = {1,2,3,4};
        root2 = createBSTwithMinHeightFromSortedArray(array2,array2.length);

        isSubtree(root,root2);


    }


    //Where t1 is very large tree and t2 is small tree and we have to find whether t2 is subtree of t1 or not?
    private static void isSubtree(Node t1, Node t2) {

        boolean result = checkForMatch(t1,t2);
        if(result)
            System.out.println("Result Match ");
        else
            System.out.println("Not match !!!");
    }

    private static boolean checkForMatch(Node t1, Node t2) {
        if(t2==null){
            return true;
        }

        return subTree(t1,t2);
    }

    private static boolean subTree(Node t1, Node t2) {

        if(t1==null){
            return  false;
        }

        if(t1.data==t2.data){
            if(matchTree(t1,t2)){
                return true;
            }
        }

        return (subTree(t1.left,t2) || subTree(t1.right,t2));
    }

    private static boolean matchTree(Node t1, Node t2) {

        if(t1==null && t2==null){
            return true;
        }

        if(t1==null || t2==null){
            return false;
        }

        if(t1.data!=t2.data){
            return false;
        }
        return (matchTree(t1.left,t2.left) && matchTree(t1.right,t2.right));

    }


    // Find path which return sum
    private static void findSum(Node root, int sum) {
        int depth = getDepth(root);
        int[] paths = new int[depth];

        findSumUtil(root,paths,sum,0);
    }

    private static void findSumUtil(Node root, int[] paths, int sum, int level) {
        if(root==null){
            return;
        }

        paths[level] = root.data;

        int total =0;
        for(int i=level;i>=0;i--){
            total = total + paths[i];
            if(total==sum){
                printPath(paths,i,level);
            }
        }


        findSumUtil(root.left,paths,sum,level+1);
        findSumUtil(root.right,paths,sum,level+1);

        paths[level] =Integer.MIN_VALUE; // for safety NOT NEEDED
    }

    private static void printPath(int[] paths, int start, int end) {

        for(int i=start;i<=end;i++){
            System.out.print(" "+paths[i]);
        }
        System.out.println();
    }



    // find all possible paths in tree
    private static void findAllpaths(Node root) {
//        int[] paths= new int[20];
        int depth = getDepth(root);
        int[] paths = new int[depth];
        findAllPathUtil(root,paths,0);
    }

    private static void findAllPathUtil(Node node, int[] paths, int level) {

        if(node==null){
            return;
        }

        paths[level] =node.data;

        if(node.left==null && node.right==null){
            printPath(paths,level);
        }
        else{
            findAllPathUtil(node.left,paths,level+1);
            findAllPathUtil(node.right,paths,level+1);
        }


    }

    private static void printPath(int[] paths, int level) {
        for(int i=0;i<=level;i++){
            System.out.print(" "+ paths[i]);
        }
        System.out.println();
    }


    private static int getDepth(Node root) {
        if(root==null){
            return 0;
        }
        else
            return 1+ Math.max(getDepth(root.left),getDepth(root.right));

    }


    //find common ancestor for given 2 nodes
    private static void findCommonAncestor(Node root, int p, int q) {

        if(!checkforAncestor(root,p) || !checkforAncestor(root,q)){
            System.out.print("Not Common ancestor between nodes");
        }
        else{
            Node result = checkForAncestorUtil(root,p,q);
            System.out.println("Common ancestor: "+result.data);
        }
    }

    private static Node checkForAncestorUtil(Node root, int p, int q) {

        boolean is_p_onLeftSide = checkforAncestor(root.left,p);
        boolean is_q_onLeftSide= checkforAncestor(root.left,q);

        // If they are true , flase or flase , true, means they are on opposite site of tree, so we can return root as common ancestor
        if(is_p_onLeftSide!=is_q_onLeftSide){
            return root;
        }
        else {
            //both are on
            if(is_p_onLeftSide && is_q_onLeftSide) {
                return checkForAncestorUtil(root.left,p,q);
            }
            else {
                return checkForAncestorUtil(root.right,p,q);
            }
        }

    }

    private static boolean checkforAncestor(Node root, int p) {
        if(root==null)
            return false;
        if(root.data==p)
                return true;

        return ( checkforAncestor(root.left,p) || checkforAncestor(root.right,p));
    }


    //find Inorder Successor ; Hint for predeccessor is same code just change for left tor right and findMin tp findMax
    // in leftSubtree

    private static void findInorderSuccesor(Node root, int data) {

        Node node = root;

        while(node.data!=data){

            if(data<node.data){
                node=node.left;
            }
            if(data>node.data){
                node=node.right;
            }
        }

        if(node==null){
            return;
        }

        Node current =node;

        if(current.right!=null){
            // case 1: where we have right subtree for node, then we have to find the minimum element from its right
            //        subtree.

            Node min = findMin(current.right);
            System.out.println(" Successor: "+ min.data);

        }
        else{
            //case 2: Where we don't have right subtree for node, then we have to go to parent , if we visit parent from left
            // then it has not visited yet so we can return that parent. But if we are visiting parent from right then, parent already
            // been visited and then we need to go up in tree till we find the parent which are visiting from left. As we can't go
            // from child to parent directly we can design the data structure that way. then we can easily visit parent directly
            // but even we don't have such data structure we can traverse from root to given node adn keep track of all the accenstor
            // case is only when we don't have right subtree for given node.

            Node ancestor = root;
            Node successor = null;

            while(ancestor!=current){

                if(data < ancestor.data){
                    successor =ancestor;
                    ancestor = ancestor.left;
                }
                else {
                    ancestor=ancestor.right;
                }
            }

            if(successor!=null){
                System.out.println(" Successor: "+ successor.data);
            }
            else{
                System.out.println(" No Successor Exists:");
            }
        }
    }

    private static Node findMin(Node node) {
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }


    //Dispaly levelWise nodes from tree

    private static void displayLevelWiseNodes(ArrayList<LinkedList<Node>> result) {
        for(LinkedList<Node> list: result){

            for(Node item:list){
                System.out.print(" "+item.data);
            }
            System.out.println("");

        }
    }

    private static ArrayList<LinkedList<Node>> createLevelwiseLists() {

        //first we are creating BST
        Tree tree = new Tree();
        Node root = null;
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int start =0, end = (array.length-1);
        root = createBST(array,start,end);

        //Now start process of creating level wise lists
        ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();

        createLevelwiseLinkedList(root,lists,0);
        return lists;
    }

    private static void createLevelwiseLinkedList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
        if(root==null){
            return;
        } //base case

        LinkedList<Node> list = null;

        if(lists.size() == level){
            list = new LinkedList<Node>();
            lists.add(list);
        }
        else{
            list= lists.get(level);
        }

        list.add(root);
        createLevelwiseLinkedList(root.left,lists,level+1);
        createLevelwiseLinkedList(root.right,lists,level+1);
    }


    //create a BST with Minimun height so it is complete.
    private static Node createBSTwithMinHeightFromSortedArray(int[] array, int length) {
        Tree tree =new Tree();
        Node root = null;
        int start =0, end = length-1;
        root = createBST(array,start,end);
        tree.preorder(root);

        System.out.println("\nHeight of tree: "+ tree.getHeight(root));

        boolean result = tree.isBalanced(root);
        System.out.println("is balanced result: "+ result);
        return root;
    }

    private static Node createBST(int[] array, int start, int end) {
        if(start>end){
            return null;
        }

        int mid = (start+end)/2;
        Node root = new Node(array[mid]);
        root.left = createBST(array,start,mid-1);
        root.right = createBST(array,mid+1,end);

        return root;
    }

    private static void treeTravsersalMethods(Tree tree, Node root) {

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
        tree.preorder(root);
        tree.postorder(root);
        tree.delete(root,80);
        System.out.println("\nAfter deleting 90");
        tree.inorder(root);
        System.out.println();
        tree.BFS(root);

    }



    //validate if generated tree is balanced or not
    private static void checkforBalancedTree(Tree tree, Node root) {
        root = tree.insert(root,10);
        root = tree.insert(root,20);
        root = tree.insert(root,30);
        root = tree.insert(root,40);
        root = tree.insert(root,5);
        root = tree.insert(root,6);
        root = tree.insert(root,25);


        boolean heightDifference = tree.isBalanced(root);
        if(heightDifference)
            System.out.println("Balanced: ");
        else
            System.out.println("Not balanced:" );


        boolean heightDifferenceEfficent = tree.isBalancedEfficientWay(root);
        if(heightDifference)
            System.out.println("Effiecient way: Balanced ");
        else
            System.out.println("Effiecient: Not balanced" );
    }
}
