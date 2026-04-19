/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if(root == null) return emptyList()
        val queue = ArrayDeque<TreeNode>()
        val result = mutableListOf<Int>()
        queue.addFirst(root)
        var levelCount = queue.size
        while(queue.isNotEmpty()){
            val current = queue.removeLast()
            if(current.left != null){
                queue.addFirst(current.left!!)
            }
            if(current.right != null){
                queue.addFirst(current.right!!)
            }
            levelCount -= 1
            if(levelCount == 0){
                result.add(current.`val`)
                levelCount = queue.size
            }
        }
        return result
    }
}
