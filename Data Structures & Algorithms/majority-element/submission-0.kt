class Solution {
    fun majorityElement(nums: IntArray): Int {
        nums.sort()
        val mid = nums.size / 2
        return nums[mid]
    }
}
