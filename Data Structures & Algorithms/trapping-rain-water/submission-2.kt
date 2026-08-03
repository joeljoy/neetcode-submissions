class Solution {
    fun trap(height: IntArray): Int {
        val leftHeights = IntArray(height.size)
        var maxLeftHeight = height[0]
        for(left in 1..<height.size){
            leftHeights[left] = maxLeftHeight
            maxLeftHeight = max(maxLeftHeight, height[left])
        }
        println("left:${leftHeights.joinToString(",")}")
        val rightHeights = IntArray(height.size)
        var maxRightHeight = height[height.size - 1]
        for(right in height.size - 2 downTo 0){
            rightHeights[right] = maxRightHeight
            maxRightHeight = max(maxRightHeight, height[right])
        }
        println("right:${rightHeights.joinToString(",")}")
        var totalVolume = 0
        for(idx in height.indices){
            val volume = min(leftHeights[idx], rightHeights[idx]) - height[idx]
            if(volume < 0) continue
            totalVolume += volume
        }
        return totalVolume
    }
}
