class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length + 1)
        dp[0] = true
        for(i in 0..s.length){
            for(word in wordDict){
                val wl = word.length
                if(dp[i]){
                    break
                }
                dp[i] = i - wl >= 0 && s.substring(i-wl, i) == word && dp[i-wl]
            }
        }
        return dp[s.length]
    }
}
