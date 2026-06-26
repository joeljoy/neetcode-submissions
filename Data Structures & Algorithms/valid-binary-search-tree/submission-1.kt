/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {

        fun helper(root: TreeNode?, min:Int, max:Int):Boolean{
            if(root == null) return true

            val left = helper(root!!.left, min, root!!.`val`)
            val right = helper(root!!.right, root!!.`val`, max)

            return (root!!.`val` > min && root!!.`val` < max) && left && right
        }

        return helper(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }
}
