class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val memo = mutableMapOf<Pair<Int, Int>, Int>()
        fun backtrack(idx: Int, lastAddedIdx: Int): Int {
            if (idx == nums.size) {
                return 0
            }
            val key:Pair<Int, Int> = idx to lastAddedIdx
            memo[key]?.let {
                return it
            }
            val exclude = backtrack(idx + 1, lastAddedIdx)
            val include = if (lastAddedIdx == -1 || nums[lastAddedIdx] < nums[idx]) {
                1 + backtrack(idx + 1, idx)
            } else {
                0
            }

            val result = max(exclude, include)
            memo[key] = result
            return result
        }
        return backtrack(0, -1)
    }
}
