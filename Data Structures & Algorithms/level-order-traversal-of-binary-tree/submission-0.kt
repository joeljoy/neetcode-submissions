/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if(root == null) return emptyList()
        val result = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root!!)
        while(queue.isNotEmpty()){
            val values = mutableListOf<Int>()
            val size = queue.size
            (0 until size).forEach{
                val node = queue.removeFirst()
                values.add(node.`val`)

                node.left?.let{queue.addLast(it)}
                node.right?.let{queue.addLast(it)}
            }
            result.add(values)
        }
        return result
    }
}
