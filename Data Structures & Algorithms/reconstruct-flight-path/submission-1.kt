class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val sortedTicket = tickets.sortedWith(compareBy({ it[0] }, { it[1] })).reversed()

        val adjList = mutableMapOf<String, MutableList<String>>()
        for (ticket in sortedTicket) {
            val from = ticket[0]
            val to = ticket[1]
            adjList.getOrPut(from) { mutableListOf() }.add(to)
        }

        val result = mutableListOf<String>()

        fun dfs(dest: String) {
            val destinations = adjList[dest] ?: mutableListOf()
            while (destinations.isNotEmpty()) {
                val next = destinations.removeLast()
                dfs(next)
            }
            result.add(dest)
        }
        dfs("JFK")
        return result.reversed()
    }
}
