/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        var maxSumSoFar = Int.MIN_VALUE
        fun helper(root:TreeNode?):Int{
            if(root == null) return 0

            val left = helper(root?.left)
            val right = helper(root?.right)

            maxSumSoFar = max(maxSumSoFar, root!!.`val`)
            maxSumSoFar = max(maxSumSoFar, left + root!!.`val`)
            maxSumSoFar = max(maxSumSoFar, right + root!!.`val`)
            maxSumSoFar = max(maxSumSoFar, left + root!!.`val` + right)

            return max(root!!.`val`, root!!.`val` + max(left, right))
        }
        helper(root)
        return maxSumSoFar
    }
}
