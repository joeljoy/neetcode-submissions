class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        while(left < right){
            val mid = left + (right - left) / 2
            if(mid != 0 && nums[mid - 1] > nums[mid]){
                return nums[mid]
            }else if(nums[mid] > nums[right]){
                left = mid + 1
            }else{
                right = mid - 1
            }
        }
        return nums[left]
    }
}
