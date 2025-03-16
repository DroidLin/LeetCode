package leetcode

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 * Example:
 *
 * ```
 * var li = ListNode(5)
 * var v = li.`val`
 * // Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 * ```
 */
class Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val lengthL1 = lengthOfNode(l1)
        val lengthL2 = lengthOfNode(l2)
        var maxNode = if (lengthL1 > lengthL2) l1 else l2
        var minNode = if (lengthL1 > lengthL2) l2 else l1

        val head = maxNode
        var tail: ListNode? = null

        var plus = 0
        while (maxNode != null && minNode != null) {
            val `val` = maxNode.`val` + minNode.`val` + plus
            maxNode.`val` = `val` % 10
            plus = `val` / 10

            if (maxNode.next == null) {
                tail = maxNode
            }

            maxNode = maxNode.next
            minNode = minNode.next
        }

        while (maxNode != null) {
            val `val` = maxNode.`val` + plus
            maxNode.`val` = `val` % 10
            plus = `val` / 10

            if (maxNode.next == null) {
                tail = maxNode
                break
            }
            maxNode = maxNode.next
        }

        if (plus > 0) {
            tail?.next = ListNode(plus)
        }

        return head
    }

    private fun lengthOfNode(node: ListNode?): Int {
        var count = 0
        var tmp = node
        while (tmp != null) {
            count++
            tmp = tmp.next
        }
        return count
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {

}