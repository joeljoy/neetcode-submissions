class Solution {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        nums.sortDescending()
        val sum = nums.sum()
        if (sum % k != 0) return false
        val target = sum / k
        fun backtrack(sums: IntArray, idx: Int): Boolean {
            if (idx == nums.size) return true
            for (i in 0..<k) {
                if (i > 0 && sums[i] == sums[i - 1]) continue
                if (sums[i] + nums[idx] > target) continue

                sums[i] += nums[idx]
                if (backtrack(sums, idx + 1)) {
                    return true
                }
                sums[i] -= nums[idx]
            }
            return false
        }

        val sums = IntArray(k)
        return backtrack(sums, 0)
    }
}

