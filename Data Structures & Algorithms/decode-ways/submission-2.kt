class Solution {
    fun numDecodings(s: String): Int {
        val memo = mutableMapOf<Int, Int>()
        
        fun backtrack(idx:Int):Int{
            if(idx == s.length){
               return 1
            }
            if(s[idx] == '0') return 0
            if(memo.contains(idx)) return memo[idx]!!

            var count = backtrack(idx + 1)
            if(s.substring(idx, min(idx + 2, s.length)).toInt() in 10..26){
                count += backtrack(idx + 2 )
            }
            memo[idx] = count
            return memo[idx]!!
        }
        return backtrack(0)
    }
}
