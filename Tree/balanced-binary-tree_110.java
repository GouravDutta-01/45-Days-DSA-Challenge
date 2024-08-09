// Question Link : https://leetcode.com/problems/balanced-binary-tree/
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
    public boolean isBalanced(TreeNode root) {
        return solve(root);    
    }
    public boolean solve(TreeNode root){
        if(root == null){
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh-rh) > 1){
            return false;
        }
        boolean l = solve(root.left);
        boolean r = solve(root.right);
        return l && r;
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l, r) + 1;
    }
}