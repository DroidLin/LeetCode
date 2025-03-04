/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 */
class Solution189 {
    //    fun rotate(nums: IntArray, k: Int): Unit {
//        if (k == nums.size) return
//        val iteration = if (k < nums.size) k else k % nums.size
//        val newCopy = nums.copyOf()
//        for (i in nums.indices) {
//            nums[i] = newCopy[(i - iteration + nums.size) % nums.size]
//        }
//    }
    fun rotate(nums: IntArray, k: Int): Unit {
        if (k == nums.size) return
        val iterator = k % nums.size
        if (iterator == 0) return
        reverse(nums, 0, nums.size - 1)
        reverse(nums, 0, iterator - 1)
        reverse(nums, iterator, nums.size - 1)
    }

    private fun reverse(nums: IntArray, start: Int, end: Int): Unit {
        var head = start
        var tail = end
        while (head < tail) {
            val temp = nums[head]
            nums[head] = nums[tail]
            nums[tail] = temp
            head++
            tail--
        }
    }
}

fun main() {
    val nums = intArrayOf(1,2)
    Solution189().rotate(nums, 3)
    println("nums: ${nums.contentToString()}")
}