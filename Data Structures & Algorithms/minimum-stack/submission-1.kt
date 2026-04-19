class MinStack() {
    private val stack = ArrayDeque<Int>()
    private val minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        if(minStack.isEmpty() || `val` <= minStack.last()){
            minStack.addLast(`val`)
        }
    }

    fun pop() {
        val element = stack.removeLast()
        if(minStack.isNotEmpty() && minStack.last() == element){
            minStack.removeLast()
        }
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }
}
