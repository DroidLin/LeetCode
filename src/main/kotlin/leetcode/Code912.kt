package leetcode

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 10^4
 * -5 * 10^4 <= nums[i] <= 5 * 10^4
 */
class Solution912 {
    fun sortArray(nums: IntArray): IntArray {
        quickSort(nums, 0, nums.size - 1)
        return nums
    }

    private fun quickSort(array: IntArray, startIndex: Int, endIndex: Int) {
        if (startIndex >= endIndex) {
            return
        }

        var left = startIndex
        var right = endIndex
        val pointValue = array[left]
        while (left < right) {
            while (left < right && array[right] >= pointValue) {
                right--
            }
            if (left < right) {
                array[left++] = array[right]
            }
            while (left < right && array[left] <= pointValue) {
                left++
            }
            if (left < right) {
                array[right--] = array[left]
            }
        }
        array[left] = pointValue
        quickSort(array, startIndex, left - 1)
        quickSort(array, right + 1, endIndex)
    }
}

fun main() {
    val sort = Solution912().sortArray(intArrayOf(3, 4, 1, 2, 3, 11, 65, 8, 9, 0))
    println("sort: ${sort.contentToString()}")
}