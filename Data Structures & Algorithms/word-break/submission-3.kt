class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val setDict = wordDict.toSet()
        val memo = mutableMapOf<Int, Boolean>()

        fun backtrack(start:Int):Boolean{
            if(start == s.length) return true
            memo[start]?.let{
                return it
            }

            for(len in 1..s.length){
                val word = s.substring(start, min(start + len, s.length))
                if(setDict.contains(word).not()) continue
                if(backtrack(start + len)){
                    memo[start] = true
                    return true
                }
            }
            memo[start] = false
            return false
        }
        return backtrack(0)
    }
}
