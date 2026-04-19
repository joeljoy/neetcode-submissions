class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stack = ArrayDeque<Int>()

        for(idx in temperatures.indices){
            while(stack.isNotEmpty() && temperatures[stack.last()] < temperatures[idx]){
                val rIdx = stack.removeLast()
                result[rIdx] = idx - rIdx
            }

            stack.addLast(idx)
        }

        while(stack.isNotEmpty()){
            val rIdx = stack.removeLast()
            result[rIdx] = 0
        }
        return result
    }
}
