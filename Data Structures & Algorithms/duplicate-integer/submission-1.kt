class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val sorted = nums.sorted()
        for(i in 0..<sorted.size - 1){
            if(sorted[i] == sorted[i + 1]){
                return true
            }
        }
        return false
    }
}
