/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
      var count = 0
      var smallest : Int? = null
      fun inorder(root:TreeNode?){
        if(root == null || smallest != null) return

        inorder(root?.left)
        count += 1
        if(count == k){
            smallest = root!!.`val`
            return
        }
        inorder(root?.right)
      }
      inorder(root)
      return smallest!!
    }
}
