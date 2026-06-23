/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var current : ListNode? = null
        var head : ListNode? = null
        var ptr1 = list1
        var ptr2 = list2

        while(ptr1 != null && ptr2 != null){
            if(ptr1.`val` <= ptr2.`val`){
                val next = ptr1.next
                ptr1.next = null
                if(current == null){
                    current = ptr1
                    head = current
                }else{
                    current.next = ptr1
                    current = current.next
                }
                ptr1 = next
            }else{
                val next = ptr2.next
                ptr2.next = null
                if(current == null){
                    current = ptr2
                    head = current
                }else{
                    current.next = ptr2
                    current = current.next
                }
                ptr2 = next
            }
        }

        while(ptr1 != null){
            val next = ptr1.next
            ptr1.next = null
            if(current == null){
                    current = ptr1
                     head = current
            }else{
                current.next = ptr1
                current = current.next
            }
            ptr1 = next
        }

        while(ptr2 != null){
             val next = ptr2.next
            ptr2.next = null
            if(current == null){
                current = ptr2
                 head = current
            }else{
                current.next = ptr2
                current = current.next
            }
            ptr2 = next
        }
        return head
    }
}
