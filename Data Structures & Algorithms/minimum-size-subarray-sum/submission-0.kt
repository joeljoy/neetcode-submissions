class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var sum = 0
        var left = 0
        var length = Int.MAX_VALUE

        for(right in 0..<nums.size){
            sum += nums[right]
            while(sum >= target){
                length = min(length, right - left + 1)
                sum -= nums[left]
                left += 1
            }
        }
        return if(length == Int.MAX_VALUE) 0 else length
    }
}
