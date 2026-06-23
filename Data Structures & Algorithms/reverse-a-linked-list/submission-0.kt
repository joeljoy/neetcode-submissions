/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    private var newHead : ListNode? = null

    fun reverseList(head: ListNode?): ListNode? {
       helper(head)
       return newHead
    }

    private fun helper(head:ListNode?):ListNode?{
        if(head == null){
            return head
        }

        val prev = helper(head.next)
        head.next = null
        prev?.next = head
        if(newHead == null){
            newHead = head
        }
        return head
    }
}
