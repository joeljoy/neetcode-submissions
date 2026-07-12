class Solution {
      fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val parent = IntArray(accounts.size) {
            it
        }

        fun find(x: Int): Int {
            if (parent[x] != x) {
                parent[x] = find(parent[x])
            }
            return parent[x]
        }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)

            if (rootX != rootY) {
                parent[rootY] = rootX
            }
        }

        val emailToAccId = mutableMapOf<String, Int>()
        for (accountIdx in 0..<accounts.size) {
            for (emailIdx in 1..<accounts[accountIdx].size) {
                val email = accounts[accountIdx][emailIdx]

                if (emailToAccId.containsKey(email)) {
                    union(accountIdx, emailToAccId[email]!!)
                } else {
                    emailToAccId[email] = accountIdx
                }
            }
        }

        val accIdToEmails = mutableMapOf<Int, MutableList<String>>()
        for ((email, accId) in emailToAccId.entries) {
            val groupId = find(accId)
            accIdToEmails.getOrPut(groupId) { mutableListOf() }.add(email)
        }

        val result = mutableListOf<List<String>>()
        for ((groupId, emails) in accIdToEmails) {
            val name = accounts[groupId].first()
            result.add(listOf(name) + emails.sorted())
        }
        return result
    }
}
