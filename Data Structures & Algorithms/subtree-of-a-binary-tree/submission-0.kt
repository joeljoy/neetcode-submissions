/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        var isFound = false
        fun helper(node:TreeNode?){
            if(node == null) return
            if(node?.`val` == subRoot?.`val`){
                if(isSameTree(node, subRoot)){
                    isFound = true
                    return
                }
            }
            if(isFound.not()){
                helper(node?.left)
            }
            if(isFound.not()){
                helper(node?.right)
            }
        }
        helper(root)
        return isFound
    }

    private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if(p == null && q == null) return true
        if(p == null && q != null) return false
        if(p != null && q == null) return false

        val isLeftSame = isSameTree(p?.left, q?.left)
        val isRightSame = isSameTree(p?.right, q?.right)

        return p!!.`val` == q!!.`val` && isLeftSame && isRightSame
    }
}
