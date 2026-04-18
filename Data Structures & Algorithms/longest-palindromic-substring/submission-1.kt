class Solution {
    fun longestPalindrome(s: String): String {
        val dp = Array(s.length) {
            BooleanArray(s.length)
        }
        var result: String = ""
        //fill 1 length substring
        for (i in 0..<s.length) {
            dp[i][i] = true
            result = "" + s[i]
        }

        //fill 2 length substring
        for (i in 0..<s.length - 1) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = true
                result = s.substring(i, i + 2)
            }
        }

        //remaining length substring
        val n = s.length
        for (len in 3..n) {
            for (i in 0..(n - len)) {
                val j = i + len - 1
                if (s[i] == s[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true
                    result = s.substring(i, j + 1)
                }
            }
        }
        return result
    }
}
