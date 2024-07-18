// Question Link : https://leetcode.com/problems/diameter-of-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return diameter;    
    }
    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = solve(root.left);
        int rh = solve(root.right);
        diameter = Math.max(lh+rh, diameter);
        return Math.max(lh, rh) + 1;
    }
}