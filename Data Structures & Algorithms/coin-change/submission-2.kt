class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        return tabular(amount, coins)
        val minCount = recursive(amount, coins)
        return if(minCount == Int.MAX_VALUE){
            -1
        }else{
            minCount
        }
    }

    private fun recursive(amount:Int, coins:IntArray):Int{
        if(amount < 0){
            return Int.MAX_VALUE
        }
        if(amount == 0){
            return 0
        }

        var min = Int.MAX_VALUE
        for(coin in coins){
            val count = recursive(amount - coin, coins)
            min = min(min, count)
        }
        if(min == Int.MAX_VALUE){
            return min
        }else{
            return 1 + min
        }
    }

    private fun tabular(amount:Int, coins:IntArray):Int{
        val dp = IntArray(amount + 1){
            -1
        }
        dp[0] = 0
        for(value in 1..amount){
            var min = Int.MAX_VALUE
            for(coin in coins){
                val count = if(value - coin == 0){
                    0
                }else if(value - coin > 0){
                    if(dp[value - coin] < 0){
                        Int.MAX_VALUE
                    }else{
                        dp[value - coin]
                    }
                }else{
                    Int.MAX_VALUE
                }
                min = min(min, count)
            }
            dp[value] = if(min == Int.MAX_VALUE){
                -1
            }else{
                1+min
            }
        }
        return dp[amount]
    }
}
