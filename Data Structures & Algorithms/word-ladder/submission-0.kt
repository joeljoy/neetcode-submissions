class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val visited = mutableSetOf<String>()
        val queue = ArrayDeque<String>()
        val parents = mutableMapOf<String,String>()
        val adjMap = generateAdjacencyMap(beginWord, endWord, wordList)
        queue.addLast(beginWord)
        visited.add(beginWord)
        while(queue.isNotEmpty()){
            val word = queue.removeFirst()
            if(word == endWord){
                var count = 0
                var parent:String? = word
                while(parent != null){
                    parent = parents[parent]
                    count += 1
                }
                return count
            }
            for(neighbour in adjMap[word]!!){
                if(!visited.contains(neighbour)){
                    queue.addLast(neighbour)
                    visited.add(neighbour)
                    parents[neighbour] = word
                }
            }
        }
        return 0
    }

    private fun generateAdjacencyMap(beginWord:String, endWord:String, wordList:List<String>):Map<String, List<String>>{
        val allWords = ArrayList<String>().apply{
            add(beginWord)
            addAll(wordList)
        }
        val map = mutableMapOf<String, List<String>>()
        for(i in 0 until allWords.size){
            val neighbours = mutableListOf<String>()
            for(j in 0 until allWords.size){
                if(i != j && isNeighbour(allWords[i], allWords[j])){
                    neighbours.add(allWords[j])
                }
            }
            map[allWords[i]] = neighbours
        }
        return map
    }

    private fun isNeighbour(a:String, b:String):Boolean{
        if(a.length != b.length){
            return false
        }
        var difference = 0
        for(i in 0 until a.length){
            if(a[i] != b[i]){
                difference += 1
            }
            if(difference > 1){
                return false
            }
        }
        return difference == 1
    }
}
