class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        // return helper(0,0, text1, text2)
        return dp(text1, text2)
    }

    private fun dp(text1:String, text2:String):Int{
        val dp = Array(text1.length + 1){
            IntArray(text2.length + 1)
        }

        for(idx1 in 1..text1.length){
            for(idx2 in 1..text2.length){
                dp[idx1][idx2] = if(text1[idx1-1] == text2[idx2-1]){
                    1 + dp[idx1-1][idx2-1]
                }else{
                    max(dp[idx1-1][idx2], dp[idx1][idx2-1])
                }
            }
        }
        return dp[text1.length][text2.length]
    }

    private fun helper(idx1:Int, idx2:Int, text1:String, text2:String):Int{
        if(idx1 == text1.length){
            return 0
        }

        if(idx2 == text2.length){
            return 0
        }

        if(text1[idx1] == text2[idx2]){
           return 1 + helper(idx1+1, idx2+1, text1, text2)
        }
        return max(helper(idx1, idx2+1, text1, text2), helper(idx1+1, idx2, text1, text2))
    }
}
