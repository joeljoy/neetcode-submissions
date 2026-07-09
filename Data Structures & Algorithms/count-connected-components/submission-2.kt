class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        var components = n
        val parent = IntArray(n){
            it
        }

        fun find(x:Int):Int{
            if(parent[x] != x){
                parent[x] = find(parent[x])
            }
            return parent[x]
        }

        fun union(x:Int, y:Int){
            val rootx = find(x)
            val rooty = find(y)

            if(rootx != rooty){
                parent[rooty] = rootx
                components -= 1
            }
        }

       
        for(edge in edges){
            union(edge[0], edge[1])
        }
        return components
    }
}
