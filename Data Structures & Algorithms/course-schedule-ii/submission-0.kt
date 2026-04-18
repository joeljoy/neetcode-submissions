class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val degrees = IntArray(numCourses){
            0
        }
        val dependencies = Array(numCourses){
            mutableListOf<Int>()
        }
        for(req in prerequisites){
            val courseA = req[0]
            val courseB = req[1]

            dependencies[courseB].add(courseA)
            degrees[courseA] += 1
        }

        val queue = ArrayDeque<Int>()
        for(course in 0..<numCourses){
            val degree = degrees[course]
            if(degree == 0){
                queue.addLast(course)
            }
        }
        val result = mutableListOf<Int>()
        while(queue.isNotEmpty()){
            val course = queue.removeFirst()
            result.add(course)

            for(dep in dependencies[course]){
                degrees[dep]--
                if(degrees[dep] == 0){
                    queue.addLast(dep)
                }
            }
            
        }
        if(result.size == numCourses){
            return result.toIntArray()
        }else{
           return intArrayOf()
        }
    }
}
