class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        if(people.any{it > limit}) return 0
        people.sort()
        //Greedily we can pair heaviest and lightest person
        var left = 0
        var right = people.size - 1
        var count = 0
        while(left <= right){
            val remaining = limit - people[right]
            right -= 1
            count += 1

            if(people[left] <= remaining){
                left += 1
            }
        }
        return count
    }
}


// given people and their weight.
// each boat can carry 2 people, such that the combined weight shall not exceed limit.
// return the min. no:off boat required.

//1,2,4,5

