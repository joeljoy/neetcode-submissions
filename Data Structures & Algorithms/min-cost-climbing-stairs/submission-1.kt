class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = IntArray(cost.size + 1)
        dp[0] = cost[0]
        dp[1] = cost[1]

        for(step in 2..cost.size){
            dp[step] = if(step != cost.size){
                cost[step] + min(dp[step - 1], dp[step - 2])
            }else{
                min(dp[step - 1], dp[step - 2])
            }
        }
        return dp[cost.size]
    }
}
