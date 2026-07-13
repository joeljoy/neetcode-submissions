class Solution {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
      nums.sortDescending()  
      val sum = nums.sum()
      if(sum % k != 0) return false
        val target = sum / k
        fun backtrack(sums:IntArray, idx:Int):Boolean{
            if(sums.any{ it > target }) return false
            if(idx == nums.size){
                for(i in 1..<k){
                    if(sums[i] != sums [i-1]) return false
                }
                return true
            }

            var result = false
            for(i in 0..<k){
                if(sums[i] + nums[idx] > target) continue

                sums[i] = sums[i] + nums[idx]
                result = result || backtrack(sums, idx + 1)
                sums[i] = sums[i] - nums[idx]
            }
            return result
        }
        val sums = IntArray(k)
        return backtrack(sums, 0)
    }
}

