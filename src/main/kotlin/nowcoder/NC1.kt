package nowcoder

import kotlin.math.max
import kotlin.math.min

object SolutionNC1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    fun solve(s: String, t: String): String {
        val list = ArrayList<Int>(max(s.length, t.length))
        val iteratorCount = min(s.length, t.length)
        var nextPlus = 0
        for (index in 0 until iteratorCount) {
            val sValue = s[s.length - 1 - index] - '0'
            val tValue = t[t.length - 1 - index] - '0'
            val plusResult = sValue + tValue + nextPlus
            list.add(0, plusResult % 10)
            nextPlus = plusResult / 10
        }
        val maxStr = if (s.length > t.length) s else t
        for (index in maxStr.length - 1 - iteratorCount downTo 0 ) {
            val mValue = maxStr[index] - '0'
            val plusResult = mValue + nextPlus
            list.add(0, plusResult % 10)
            nextPlus = plusResult / 10
        }
        if (nextPlus > 0) {
            list.add(0, nextPlus)
        }
        return list.joinToString(separator = "")
    }
}

fun main() {
    val result = SolutionNC1.solve("11", "99")
    println("result: $result")
}