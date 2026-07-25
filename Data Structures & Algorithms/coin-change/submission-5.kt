class Solution {
    val memo = mutableMapOf<Long, Int>()
    fun coinChange(coins: IntArray, amount: Int): Int {
        fun backtrack(sum:Long):Int{
            if(sum == amount.toLong()) return 0
            if(sum > amount.toLong()) return Int.MAX_VALUE
            if(memo.contains(sum)){
                return memo[sum]!!
            }
            var minCount = Int.MAX_VALUE
            for(coin in coins){
                val count = backtrack(sum + coin)
                minCount = min(count, minCount)
            }
            val value = if(minCount == Int.MAX_VALUE){
                minCount
            }else{
                1 + minCount
            }
            memo[sum] = value
            return value
        }
        val count = backtrack(0)
        return if(count == Int.MAX_VALUE){
            -1
        }else{
            count
        }
    }
}
