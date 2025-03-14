package leetcode

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
class Solution169 {
    fun majorityElement(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var count = 0
        var number = 0
        for (index in nums.indices) {
            if (count == 0) {
                number = nums[index]
            }
            if (number == nums[index]) {
                count += 1
            } else {
                count -= 1
            }
        }
        return number
    }
}

fun main() {
    val nums = intArrayOf(3,2,3)
    val k = Solution169().majorityElement(nums)
    println("k: ${k}.")
}