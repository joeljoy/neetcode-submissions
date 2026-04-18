class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        val starts = mutableListOf<Int>()

        for (num in nums) {
            if (set.contains(num - 1).not()) {
                starts.add(num)
            }
        }

        var longest = 0
        for (start in starts){
            var currentStreak = 1
            var next = start + 1

            while(set.contains(next)){
                currentStreak += 1
                next += 1
            }

            longest = max(longest, currentStreak)
        }
        return longest
    }
}
