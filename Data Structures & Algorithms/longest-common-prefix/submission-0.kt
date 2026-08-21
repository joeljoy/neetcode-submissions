class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 1) {
            return strs[0]
        }

        strs.sort()
        val first = strs[0]
        val last = strs[strs.size - 1]

        var i = 0
        while (i < minOf(first.length, last.length)) {
            if (first[i] != last[i]) {
                return first.substring(0, i)
            }
            i++
        }

        return first
    }
}
