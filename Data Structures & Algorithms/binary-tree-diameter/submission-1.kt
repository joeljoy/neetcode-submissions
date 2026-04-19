/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var longest = 0

        fun helper(root:TreeNode?):Int{
            if(root == null) return 0

            val left = helper(root.left)
            val right = helper(root.right)

            val diameter = left + right
            longest = max(longest, diameter)

            return 1 + max(left, right)
        }
        helper(root)
        return longest
    }
}
