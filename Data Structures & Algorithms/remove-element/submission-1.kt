class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var count = 0
        for(num in nums){
            if(num != `val`){
                count += 1
            }
        }

        var left = 0
        var right = nums.size - 1
        while(left < right){
            while(left < nums.size && nums[left] != `val`){
                left += 1
            }

            while(right >= 0 && nums[right] == `val`){
                right -= 1
            }

            if(left >= right) break

            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
        }

        return count

    }
}
