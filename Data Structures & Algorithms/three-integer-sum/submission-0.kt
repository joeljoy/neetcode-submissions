class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val resultSet = mutableSetOf<List<Int>>()
        for(idx in 0 until nums.size){
            var left = idx + 1
            var right = nums.size - 1

            while(left < right){
                val sum = nums[idx] + nums[left] + nums[right]
                if(sum == 0){
                    resultSet.add(listOf(nums[idx], nums[left], nums[right]))
                    left += 1
                    right -= 1
                }else if(sum < 0){
                    left += 1
                }else{
                    right -= 1
                }
            }
        }
        return resultSet.toList()
    }
}
