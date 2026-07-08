class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val arrival = BooleanArray(numCourses)
        val departure = BooleanArray(numCourses)

        val dependencies = Array(numCourses){
            mutableListOf<Int>()
        }
        var isCycle = false
        for(dependency in prerequisites){
            val courseA = dependency[0]
            val courseB = dependency[1]

            dependencies[courseB].add(courseA)
        }

        fun dfs(course:Int){
            if(arrival[course] && departure[course]) return
            if(arrival[course] && departure[course].not()){
                isCycle = true
                return
            }

            arrival[course] = true
            for(next in dependencies[course]){
                if(isCycle.not()){
                    dfs(next)
                }
            }
            departure[course] = true
        }

        for(course in 0..<numCourses){
            dfs(course)
        }
        return isCycle.not()
    }
}
