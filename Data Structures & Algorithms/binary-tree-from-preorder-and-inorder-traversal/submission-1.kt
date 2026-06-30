/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        var preorderIdx = 0
        var inorderIndexMap = mutableMapOf<Int, Int>()
        for(idx in 0 until inorder.size){
           inorderIndexMap[inorder[idx]] = idx
        }
        fun build(inStart:Int, inEnd:Int):TreeNode?{
            if(inStart > inEnd){
                return null
            }

            val mid = inorderIndexMap.get(preorder[preorderIdx])!!
            val node = TreeNode(preorder[preorderIdx++])
            node.left = build(inStart,mid - 1)
            node.right = build(mid + 1, inEnd)
            return node
        }
        return build(0, inorder.size - 1)
    }
}
