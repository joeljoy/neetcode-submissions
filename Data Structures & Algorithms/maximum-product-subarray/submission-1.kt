class Solution {
    fun maxProduct(nums: IntArray): Int {
        var maxProduct = Int.MIN_VALUE
        for(i in 0..<nums.size){
            var product = nums[i]
            maxProduct = max(product, maxProduct)
            for(j in i+1..<nums.size){
                product *= nums[j]
                maxProduct = max(product, maxProduct) 
            }
        }

        return maxProduct
    }
}
