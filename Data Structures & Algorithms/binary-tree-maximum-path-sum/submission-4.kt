/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        var maxSoFar = Int.MIN_VALUE
        fun helper(root:TreeNode?):Int{
            if(root == null) return 0

            val left = helper(root.left)
            val right = helper(root.right)

            val value = maxOf(root.`val` + left, root.`val` + right, root.`val`)
            maxSoFar = maxOf(maxSoFar, left + right + root.`val`, value)
            return value
        }
        val max = helper(root)
        maxSoFar = max(maxSoFar, max)
        return maxSoFar
    }

    private fun maxOf(a:Int, b:Int, c:Int):Int{
        return max(a,max(b,c))
    }
}
