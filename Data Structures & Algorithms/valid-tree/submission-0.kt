class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val adjList = Array(n){
            mutableListOf<Int>()
        }

        for(edge in edges){
            val vertexA = edge[0]
            val vertexB = edge[1]

            adjList[vertexA].add(vertexB)
            adjList[vertexB].add(vertexA)
        }

        val visited = BooleanArray(n)
        val parents = IntArray(n){
            -1
        }
        var isCycle = false

        fun dfs(vertex:Int){
            visited[vertex] = true
            for(next in adjList[vertex]){
                if(visited[next].not()){
                    parents[next] = vertex
                    dfs(next)
                }else if(parents[vertex] != next){
                    isCycle = true
                    return
                }
            }
        }
        var components = 0
        for(vertex in 0..<n){
            if(visited[vertex].not()){
                dfs(vertex)
                components += 1
            }
        }
        return isCycle.not() && components == 1
    }
}
