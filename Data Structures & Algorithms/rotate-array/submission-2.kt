class Solution {
    fun rotate(nums: IntArray, k: Int) {
        val nk = k % nums.size
        fun reverse(left:Int, right:Int){
            var s = left
            var e = right
            while(s <= e){
                val temp = nums[s]
                nums[s] = nums[e]
                nums[e] = temp

                s += 1
                e -= 1
            }
        }

        reverse(0, nums.size - 1)
        reverse(0, nk - 1)
        reverse(nk, nums.size - 1)
    }
}

// 8,7,6,5,4,3,2,1
//5,6,7,8,1,2,3,4