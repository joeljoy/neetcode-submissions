class Solution {
     fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val adjacencyMap = mutableMapOf<String, List<String>>()
        val visited = mutableSetOf<String>()

        fun generateNeighbours() {
            for (account in accounts) {
                val leaderEmail = account[1]
                for (i in 2 until account.size) {
                    val email = account[i]
                    adjacencyMap[leaderEmail] =
                        adjacencyMap.getOrDefault(leaderEmail, listOf()).plus(email)
                    adjacencyMap[email] =
                        adjacencyMap.getOrDefault(email, listOf()).plus(leaderEmail)
                }
            }
        }

        fun dfs(email: String, components: MutableList<String>) {
            visited.add(email)
            components.add(email)
            for (neighbour in adjacencyMap[email] ?: emptyList()) {
                if (visited.contains(neighbour).not()) {
                    dfs(neighbour, components)
                }
            }
        }

        generateNeighbours()

        val result = mutableListOf<List<String>>()
        for (account in accounts) {
            val name = account.first()
            val size = account.size
            val components = mutableListOf<String>()
            val emails = account.slice(1..<size)
            for (email in emails) {
                if (visited.contains(email).not()) {
                    dfs(email, components)
                    components.sort()
                    val merged = listOf(name) + components
                    result.add(merged)
                }
            }
        }
        return result
    }
}