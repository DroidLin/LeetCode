package leetcode

import kotlin.math.max

/**
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
class Solution5 {
    fun longestPalindrome(s: String): String {
        var start = 0
        var end = 0
        for (i in s.indices) {
            val oddLen = maxPalindrome(s, i, i)
            val evenLen = maxPalindrome(s, i, i + 1)
            val maxLength = max(oddLen, evenLen)
            if (maxLength > (end - start + 1)) {
                start = i - (maxLength - 1) / 2
                end = i + maxLength / 2
            }
        }
        return s.substring(start, end + 1)
    }

    private fun maxPalindrome(s: String, left: Int, right: Int): Int {
        var l = left
        var r = right
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        return r - l - 1
    }
}

fun main() {
    val longestPalindrome = Solution5().longestPalindrome("ccbbcd")
    println("longestPalindrome $longestPalindrome")
}