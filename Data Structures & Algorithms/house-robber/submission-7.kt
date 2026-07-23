class Solution {
    fun rob(nums: IntArray): Int {
        fun dp():Int{
            if(nums.size == 1){
                return nums[0]
            }
            val dp = IntArray(nums.size)
            dp[0] = nums[0]
            dp[1] = max(nums[0], nums[1])

            for(idx in 2..<nums.size){
                dp[idx] = max(nums[idx] + dp[idx - 2], dp[idx - 1])
            }
            return dp[nums.size - 1]
        }
        fun backtrack(idx:Int):Int{
            if(idx < 0){
                return 0
            }

            val rob = nums[idx] + backtrack(idx - 2)
            val notRob = backtrack(idx - 1)
            return max(rob, notRob)
        }
        return dp()
    }
}
