class Solution {
    fun openLock(deadends: Array<String>, target: String): Int {
        val deadendsSet = deadends.toSet()
        if ("0000" in deadendsSet) return -1
        val queue = ArrayDeque<String>()
        val visited = mutableSetOf<String>()
        queue.addLast("0000")
        visited.add("0000")
        var turns = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            repeat(size) {
                val state = queue.removeFirst()
                if (state == target) {
                    return turns
                }

                for (idx in 0..3) {
                    val forward = forward(state, idx)
                    val backward = (backward(state, idx))
            
                    if (visited.contains(forward).not() && deadendsSet.contains(forward).not()) {
                        queue.addLast(forward)
                        visited.add(forward)
                    }

                    if (visited.contains(backward).not() && deadendsSet.contains(backward).not()) {
                        queue.addLast(backward)
                        visited.add(backward)
                    }
                }
            }
            turns += 1
        }
        return -1
    }

    private fun forward(state: String, idx: Int): String {
        return state.map {
            it - '0'
        }.toMutableList()
            .let { digits ->
                digits[idx] = (digits[idx] + 1) % 10
                digits.joinToString("")
            }
    }

    private fun backward(state: String, idx: Int): String {
        return state.map {
            it - '0'
        }.toMutableList()
            .let { digits ->
                digits[idx] = (digits[idx] + 9) % 10
                digits.joinToString("")
            }
    }
}
