class Solution {
    fun maxProfit(prices: IntArray): Int {
        val memo = mutableMapOf<Pair<Int, Int>, Int>()
        fun backtrack(idx:Int, priceIdx:Int):Int{
            //base cases
            if(idx >= prices.size) return 0
            val key = idx to priceIdx

            memo[key]?.let{
                return it
            }

            var maxProfit = 0
            //buy coin: if you've not boutght and if you've not sold prev day
            if(priceIdx == -1){
                val buy = backtrack(idx + 1, idx)
                maxProfit = max(maxProfit, buy)
            }

            // sell coin
            if(priceIdx != -1){
                val profit = prices[idx] - prices[priceIdx]
                val sell = profit + backtrack(idx + 2, -1)
                maxProfit = max(maxProfit, sell)
            }

            //do nothing
            val skip = backtrack(idx + 1, priceIdx)
            maxProfit = max(maxProfit, skip)

            val value = maxProfit
            memo[key] = value
            return value
        }
        return backtrack(0, -1)
    }
}
