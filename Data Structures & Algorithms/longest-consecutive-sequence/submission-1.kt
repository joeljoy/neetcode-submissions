class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        var longest = 0
        for(num in nums){
            if(set.contains(num - 1)){
                continue
            }

            var currentSeq = 1
            var next = num + 1
            while(set.contains(next)){
                currentSeq += 1
                next += 1
            }

            longest = max(currentSeq, longest)
        }
        return longest
    }
}
