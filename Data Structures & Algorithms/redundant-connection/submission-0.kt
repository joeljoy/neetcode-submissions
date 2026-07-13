class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = IntArray(edges.size + 1){
            it
        }
        fun find(x:Int):Int{
            if(parent[x] != x){
                parent[x] = find(parent[x])
            }
            return parent[x]
        }

        fun union(x:Int, y:Int):Boolean{
            val rootX = find(x)
            val rootY = find(y)

            if(rootX != rootY){
                parent[rootY] = rootX
                return true
            }
            return false
        }

        var result : IntArray = IntArray(2)
        for(edge in edges){
            if(union(edge[0],edge[1]).not()){
                result = edge
            }
        }
        return result
    }
}
