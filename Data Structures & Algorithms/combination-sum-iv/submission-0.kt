class Solution {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val memo = mutableMapOf<Int, Int>()
        fun backtrack(sum:Int):Int{
            if(sum == target) return 1
            if(sum > target) return 0
            memo[sum]?.let{
                return it
            }
            var count = 0
            for(num in nums){
                count += backtrack(sum + num)
            }
            memo[sum] = count
            return count
        }
        return backtrack(0)
    }
}
