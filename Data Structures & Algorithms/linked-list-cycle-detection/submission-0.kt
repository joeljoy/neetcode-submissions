/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        val set = mutableSetOf<ListNode>()
        var ptr = head
        while(ptr != null){
            if(set.contains(ptr)) return true
            set.add(ptr)
            ptr = ptr.next
        }
        return false
    }
}
