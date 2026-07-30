class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val memo = mutableMapOf<Pair<Int, Int>, Int>()
        fun backtrack(idx:Int, sum:Int):Int{
            if(idx >= coins.size) return 0
            if(sum > amount) return 0
            if(sum == amount) return 1
            val key = idx to sum
            memo[key]?.let{
                return it
            }

            var ways = 0
            for(i in idx..<coins.size){
                ways += backtrack(i, sum+coins[i])
            }
            memo[key] = ways
            return ways
        }
        return backtrack(0, 0)
    }
}
