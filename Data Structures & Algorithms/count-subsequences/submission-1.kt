class Solution {
    fun numDistinct(s: String, t: String): Int {
        val memo = mutableMapOf<Pair<Int, Int>, Int>()
        fun backtrack(i:Int, j:Int):Int{
            if(j >= t.length) return 1
            if(i >= s.length) return 0

            val key = i to j
            memo[key]?.let{
                return it
            }
            val skip = backtrack(i+1, j)
            val include = if(s[i] == t[j]){
                backtrack(i+1,j+1)
            }else{
                0
            }
            val count = skip + include
            memo[key] = count
            return count
        }
        return backtrack(0,0)
    }
}
