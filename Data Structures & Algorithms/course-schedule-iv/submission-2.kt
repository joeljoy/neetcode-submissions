class Solution {
     fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val adj = Array(numCourses) { mutableSetOf<Int>() }
        val isPrereq = Array(numCourses) { mutableSetOf<Int>() }
        val indegree = IntArray(numCourses)

        for (pre in prerequisites) {
            adj[pre[0]].add(pre[1])
            indegree[pre[1]]++
        }

        val q = ArrayDeque<Int>()
        for (i in 0 until numCourses) {
            if (indegree[i] == 0) q.add(i)
        }

        while (q.isNotEmpty()) {
            val node = q.removeFirst()
            for (neighbor in adj[node]) {
                isPrereq[neighbor].add(node)
                isPrereq[neighbor].addAll(isPrereq[node])
                indegree[neighbor]--
                if (indegree[neighbor] == 0) {
                    q.add(neighbor)
                }
            }
        }

        return queries.map { isPrereq[it[1]].contains(it[0]) }
    }
}
