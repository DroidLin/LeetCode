package leetcode

import kotlin.math.min

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 *
 * 进阶：
 *
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 */
class Solution209 {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var right = 0
        var sum = 0
        var min = Int.MAX_VALUE
        while (right < nums.size) {
            sum += nums[right]
            while (sum >= target) {
                min = min(min, right - left + 1)
                sum -= nums[left]
                left++
            }
            right++
        }
        return if (min == Int.MAX_VALUE) 0 else min
    }
}

fun main() {
    val nums = intArrayOf(12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12)
    val subLen = Solution209().minSubArrayLen(213, nums)
    println("subLen: $subLen")
}