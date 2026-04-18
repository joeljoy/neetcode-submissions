class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = IntArray(cost.size + 1)
        dp[0] = cost[0]
        dp[1] = cost[1]

        for(i in 2..cost.size){
            val currentCost = if(i != cost.size){
                cost[i]
            }else{
                0
            }
            dp[i] = min(dp[i-1], dp[i-2]) + currentCost
        }
        return dp[cost.size]
    }
}

// What is the recurence relation
//f(i) = return the min cost to jump from ith stair
//.      and I can reach i from i - 1 and  i -2
// f(i) = min(f(i-1),f(i-2)) + cost[i]

//verify
//[1,2,3]

