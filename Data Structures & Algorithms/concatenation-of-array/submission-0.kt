class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        val result = IntArray(2 * nums.size)
        for(idx in 0..<nums.size){
            result[idx] = nums[idx]
            result[idx + nums.size] = nums[idx]
        }
        return result
    }
}
