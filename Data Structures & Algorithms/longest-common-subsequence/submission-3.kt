class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        
        fun dp():Int{
            val m = text1.length
            val n = text2.length

            val dp = Array(m + 1){
                IntArray(n + 1)
            }
            for(idx1 in 1..m){
                for(idx2 in 1..n){
                    dp[idx1][idx2] = if(text1[idx1 - 1] == text2[idx2 - 1]){
                        1 + dp[idx1 - 1][idx2 - 1]
                    }else{
                        max(dp[idx1 -1][idx2], dp[idx1][idx2 - 1])
                    }
                }
            }
            return dp[m][n]

        }
        fun backtrack(idx1:Int, idx2:Int):Int{
            if(idx1 == text1.length || idx2 == text2.length){
                return 0
            }

            if(text1[idx1] == text2[idx2]){
                return 1 + backtrack(idx1 + 1, idx2 + 1)
            }else{
                return max(backtrack(idx1 + 1, idx2), backtrack(idx1, idx2 + 1))
            }
        }
        return dp()
    }
}
