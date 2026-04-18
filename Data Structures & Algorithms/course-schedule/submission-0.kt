class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val arrival = BooleanArray(numCourses)
        val departure = BooleanArray(numCourses)
        val dependencies = Array(numCourses){
            mutableListOf<Int>()
        }
        for(req in prerequisites){
            val courseA = req[0]
            val courseB = req[1]

            dependencies[courseA].add(courseB)
        }
        var isCycle = false
        fun dfs(course:Int){
            if(arrival[course] && departure[course]){
                return
            }
            if(arrival[course] && !departure[course]){
                isCycle = true
                return
            }
            arrival[course] = true
            for(dep in dependencies[course]){
                dfs(dep)
            }
            departure[course] = true
        }
        for(course in 0 until numCourses){
            dfs(course)
        }
        return !isCycle
    }
}
