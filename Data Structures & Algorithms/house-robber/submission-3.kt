class Solution {
    private var result = 0
    fun rob(nums: IntArray): Int {
        return dp(nums)
    }

    private fun dp(nums:IntArray):Int{
        if(nums.size == 1){
            return nums[0]
        }
        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for(i in 2..<nums.size){
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        }
        return dp[nums.size - 1]
    }

    private fun recursive2(idx:Int, nums:IntArray):Int{
        if(idx == 0){
            return nums[0]
        }

        if(idx == 1){
            return max(nums[0], nums[1])
        }

        val max = max(recursive2(idx - 1,nums), recursive2(idx - 2, nums) + nums[idx])
        return max
    }

    private fun recursive(idx:Int, sumSoFar:Int, nums:IntArray){
        if(idx > nums.size - 1){
            result = max(result, sumSoFar)
            return
        }

        recursive(idx + 2, sumSoFar + nums[idx], nums)
        recursive(idx + 1, sumSoFar, nums)
    }
}
// What is the recurence relation?
// What is the overlapping substructure?
// f(i) returns the max amount robber can rob until i house
// f(0) = nums[0]
// f(1) = max(num[0], num[1]) // cause he can't rob adjacent houses
// f(i) = max(f(i-1), f(i-2) + nums[i-2])
