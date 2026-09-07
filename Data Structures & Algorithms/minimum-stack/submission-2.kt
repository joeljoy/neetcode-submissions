class MinStack() {

    private val main = ArrayDeque<Int>()
    private val min = ArrayDeque<Int>()

    fun push(`val`: Int) {
        main.addLast(`val`)

        if(min.isEmpty()){
            min.addLast(`val`)
            return
        }

        val minTop = min.last()
        if(`val` <= minTop){
            min.addLast(`val`)
        }
    }

    fun pop() {
        if(main.isEmpty()) return

        val top = main.last()
        main.removeLast()

        if(min.last() == top){
            min.removeLast()
        }
    }

    fun top(): Int {
        return main.last()
    }

    fun getMin(): Int {
        return min.last()
    }
}
