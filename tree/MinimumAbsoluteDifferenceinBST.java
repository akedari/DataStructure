package tree;

import java.util.ArrayList;

/**
 * Created by abhijeetkedari on 3/19/17.
 */
/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 */



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MinimumAbsoluteDifferenceinBST {

    public class Solution {
        ArrayList<Integer> inorderlist = new ArrayList<Integer>();

        public int getMinimumDifference(TreeNode root) {

            int min = findDiff(root, Integer.MAX_VALUE);
            return min;

        }

        int findDiff(TreeNode root, int diff) {
            int min = diff;
            inorder(root);
            for (int i = 1; i < inorderlist.size(); i++) {
                diff = inorderlist.get(i) - inorderlist.get(i - 1);
                if (min > diff) {
                    min = diff;
                }
                // System.out.print(" "+inorderlist.get(i));
            }

            return min;
        }

        int inorder(TreeNode root) {
            if (root == null) {
                return -1;
            } else {
                if (inorder(root.left) != -1)
                    inorderlist.add(inorder(root.left));

                inorderlist.add(root.val);

                if (inorder(root.right) != -1)
                    inorderlist.add(inorder(root.right));
            }
            return -1;
        }

    }

}
