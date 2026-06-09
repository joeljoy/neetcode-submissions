class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefix = IntArray(nums.size)
        prefix[0] = nums[0]
        for(idx in 1..<nums.size){
            prefix[idx] = prefix[idx - 1] * nums[idx]
        }

        val suffix = IntArray(nums.size)
        suffix[nums.size - 1] = nums[nums.size - 1]
        for(idx in nums.size - 2 downTo 0){
            suffix[idx] = suffix[idx + 1] * nums[idx]
        }

        val result = IntArray(nums.size)
        for(idx in 0..<nums.size){
            if(idx == 0){
                result[idx] = suffix[idx + 1]
                continue
            }

            if(idx == nums.size - 1){
                result[idx] = prefix[idx - 1]
                continue
            }

            result[idx] = prefix[idx - 1] * suffix[idx + 1]
        }
        return result
    }
}
