class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val w1Length = word1.length
        val w2Length = word2.length
        val memo = mutableMapOf<Pair<Int, Int>, Int>()

        fun backtrack(i:Int, j:Int):Int{
            if(i >= w1Length || j >= w2Length){
               if(i >= w1Length){
                return w2Length - j
               }else{
                return w1Length - i
               }
            }
            val key = i to j
            memo[key]?.let{
                return it
            }

            if(word1[i] == word2[j]){
                memo[key] = backtrack(i+1, j+1)
                return memo[key]!!
            }
            val replace = backtrack(i+1, j+1)
            val add = backtrack(i, j+1)
            val remove = backtrack(i+1, j)

            memo[key] = 1 + minOf(replace, add, remove)
            return memo[key]!!
        }
        return backtrack(0,0)
    }

    private fun minOf(a:Int, b:Int, c:Int):Int{
        return min(a,min(b,c))
    }
}
