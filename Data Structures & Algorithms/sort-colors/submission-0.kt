class Solution {
    fun sortColors(nums: IntArray) {
        val bucket = IntArray(3)
        for(num in nums){
            bucket[num] += 1
        }

        var i = 0
        for(idx in bucket.indices){
            repeat(bucket[idx]){
                nums[i] = idx
                i++
            }
        }
    }
}
