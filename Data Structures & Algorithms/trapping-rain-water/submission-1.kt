class Solution {
    fun trap(height: IntArray): Int {
        val leftHeights = IntArray(height.size)
        leftHeights[0] = 0
        var maxHeightLeft = height[0]
        for(idx in 1..<height.size){
            leftHeights[idx] = if(maxHeightLeft <= height[idx]){
                0
            }else{
                maxHeightLeft
            }
            maxHeightLeft = max(height[idx], maxHeightLeft)
        }
        println("left"+leftHeights.joinToString(","))
        val rightHeights = IntArray(height.size)
        rightHeights[height.size - 1] = 0
        var maxHeightRight = height[height.size - 1]
        for(idx in height.size - 2 downTo 0){
            rightHeights[idx] = if(maxHeightRight <= height[idx]){
                0
            }else{
                maxHeightRight
            }
            maxHeightRight = max(height[idx], maxHeightRight)
        }
        println("right"+rightHeights.joinToString(","))

        var area = 0
        for(idx in 0..<height.size){
            val left = leftHeights[idx]
            val right = rightHeights[idx]
            if(left == 0 || right == 0) continue
            area += min(left, right) - height[idx]
        }
        return area
    }
}
