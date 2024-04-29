fun main() {
    val queriesList: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("CREATE_ACCOUNT", "1", "account1"),
        mutableListOf("CREATE_ACCOUNT", "2", "account2"),
        mutableListOf("DEPOSIT", "3", "account1", "2000"),
        mutableListOf("TRANSFER", "4", "account1", "account2", "1000"),
        mutableListOf("ACCEPT_TRANSFER", "5", "account2", "transfer1"),
        mutableListOf("DEPOSIT", "6", "account1", "100"),
        mutableListOf("DEPOSIT", "7", "account2", "100")
    )
    solution(queriesList)
}

//hm.put(transfers[transferId]?.first ?: "", hm.getOrDefault(transfers[transferId]?.first ?: "", 0) - transferredAmount)
//
//trans.put(transfers[transferId]?.first ?: "", hm.getOrDefault(transfers[transferId]?.first  ?: "", 0) + transferredAmount)

fun solution1(queries: MutableList<MutableList<String>>): MutableList<String> {

    val hm: HashMap<String, Int> = hashMapOf()
    val trans: HashMap<String, Int> = hashMapOf()
    val transfers: HashMap<String, Triple<String, Long, Int>> =
        hashMapOf() // Map to store transfer information: transferId to (targetAccountId, expirationTime, transferredAmount)
    var nextTransferId = 1
    var ans: MutableList<String> = mutableListOf()

    for (query in queries) {
//        println( hm["account2"])
        when (query[0]) {
            "CREATE_ACCOUNT" -> {
                if (hm.containsKey(query[2])) {
                    ans.add("false")
                } else {
                    hm[query[2]] = 0
                    trans[query[2]] = 0
                    ans.add("true")
                }
            }

            "DEPOSIT" -> {
                if (hm.containsKey(query[2])) {
                    hm[query[2]] = hm.getOrDefault(query[2], 0) + query[3].toInt()
//                    println(hm["account2"])
                    ans.add(hm.getOrDefault(query[2], 0).toString())
                    trans[query[2]] = trans.getOrDefault(query[2], 0) + query[3].toInt()
                } else {
                    ans.add("")
                }
            }

            "PAY" -> {
                if (hm.containsKey(query[2])) {
                    if (hm.getOrDefault(query[2], 0) >= query[3].toInt()) {
                        hm[query[2]] = hm.getOrDefault(query[2], 0) - query[3].toInt()
                        ans.add(hm.getOrDefault(query[2], 0).toString())
                        trans[query[2]] = trans.getOrDefault(query[2], 0) + query[3].toInt()
                    } else {
                        ans.add("")
                    }
                } else {
                    ans.add("")
                }
            }

            "TRANSFER" -> {
                val timestamp = query[1].toLong()
                val sourceAccountId = query[2]
                val targetAccountId = query[3]
                val amount = query[4].toInt()
                if (hm.containsKey(sourceAccountId) && hm.containsKey(targetAccountId) && hm[sourceAccountId]!! >= amount) {
                    val transferId = "transfer${nextTransferId++}"
                    transfers[transferId] = Triple(
                        targetAccountId,
                        timestamp + 86400000L,
                        amount
                    ) // Store targetAccountId, expirationTime, and transferredAmount
                    hm[sourceAccountId] = hm[sourceAccountId]!! - amount
                    ans.add(transferId)
                } else {
                    ans.add("")
                }

            }

            "ACCEPT_TRANSFER" -> {
                val timestamp = query[1].toLong()
                val accountId = query[2]
                val transferId = query[3]
                if (transfers.containsKey(transferId) && transfers[transferId]?.first == accountId && transfers[transferId]?.second!! >= timestamp) {
                    val transferredAmount = transfers[transferId]?.third
                        ?: 0 // Fetch transferredAmount from transfers HashMap
//                    println(transferredAmount)
                    hm[accountId] = hm.getOrDefault(accountId, 0) + transferredAmount
//                    println(hm[accountId])
                    trans[accountId] = trans.getOrDefault(accountId, 0) + transferredAmount
                    // Update source account's balance as well
                    val sourceAccountId = transfers[transferId]?.first
//                    hm[sourceAccountId ?: ""] = 0
//                    trans[sourceAccountId ?: ""] = 0
                    hm.put(
                        transfers[transferId]?.first ?: "",
                        hm.getOrDefault(transfers[transferId]?.first ?: "", 0) - transferredAmount
                    )

                    trans.put(
                        transfers[transferId]?.first ?: "",
                        hm.getOrDefault(transfers[transferId]?.first ?: "", 0) + transferredAmount
                    )
                    transfers.remove(transferId)
                    ans.add("true")
                } else {
                    ans.add("false")
                }

            }

            "TOP_ACTIVITY" -> {
                val number = query[2].toInt()
                val sortedKey: List<String> =
                    trans.entries.sortedWith(compareByDescending<Map.Entry<String, Int>> { it.value }.thenBy { it.key })
                        .take(number).map { it.key }
                var transAns: String = ""
                for (i in sortedKey.indices) {
                    transAns = transAns + sortedKey[i] + "(" + trans.getOrDefault(sortedKey[i], 0)
                        .toString() + ")" + ", "
                }
                if (transAns.isNotEmpty()) {
                    transAns = transAns.dropLast(2)
                }
                ans.add(transAns)
            }
        }
    }
    return ans
}


fun solution(queries: MutableList<MutableList<String>>): MutableList<String> {

    val hm: HashMap<String, Int> = hashMapOf()
    val trans: HashMap<String, Int> = hashMapOf()
    val transfers: HashMap<String, Triple<String, String, Long>> =
        hashMapOf() // Map to store transfer information: transferId to (sourceAccountId, targetAccountId, expirationTime)
    var nextTransferId = 1
    var ans: MutableList<String> = mutableListOf()

    for (query in queries) {
        when (query[0]) {
            "CREATE_ACCOUNT" -> {
                if (hm.containsKey(query[2])) {
                    ans.add("false")
                } else {
                    hm[query[2]] = 0
                    trans[query[2]] = 0
                    ans.add("true")
                }
            }

            "DEPOSIT" -> {
                if (hm.containsKey(query[2])) {
                    hm[query[2]] = hm.getOrDefault(query[2], 0) + query[3].toInt()
                    ans.add(hm.getOrDefault(query[2], 0).toString())
                    trans[query[2]] = trans.getOrDefault(query[2], 0) + query[3].toInt()
                } else {
                    ans.add("")
                }
            }

            "PAY" -> {
                if (hm.containsKey(query[2])) {
                    if (hm.getOrDefault(query[2], 0) >= query[3].toInt()) {
                        hm[query[2]] = hm.getOrDefault(query[2], 0) - query[3].toInt()
                        ans.add(hm.getOrDefault(query[2], 0).toString())
                        trans[query[2]] = trans.getOrDefault(query[2], 0) + query[3].toInt()
                    } else {
                        ans.add("")
                    }
                } else {
                    ans.add("")
                }
            }

            "TRANSFER" -> {
                val timestamp = query[1].toLong()
                val sourceAccountId = query[2]
                val targetAccountId = query[3]
                val amount = query[4].toInt()
                if (hm.containsKey(sourceAccountId) && hm.containsKey(targetAccountId) && hm[sourceAccountId]!! >= amount) {
                    val transferId = "transfer${nextTransferId++}"
                    transfers[transferId] = Triple(
                        sourceAccountId,
                        targetAccountId,
                        timestamp + 86400000L
                    ) // Store sourceAccountId, targetAccountId, and expirationTime
                    hm[sourceAccountId] = hm[sourceAccountId]!! - amount
                    ans.add(transferId)
                } else {
                    ans.add("")
                }
            }

            "ACCEPT_TRANSFER" -> {
                val timestamp = query[1].toLong()
                val accountId = query[2]
                val transferId = query[3]
                if (transfers.containsKey(transferId) && transfers[transferId]?.second == accountId && transfers[transferId]?.third!! >= timestamp) {
                    val transferredAmount = transfers[transferId]?.third
                        ?: 0 // Fetch transferredAmount from transfers HashMap
                    val sourceAccountId = transfers[transferId]?.first
                    hm[accountId] = (hm.getOrDefault(accountId, 0) + transferredAmount).toInt()
                    trans[accountId] =
                        (trans.getOrDefault(accountId, 0) + transferredAmount).toInt()
                    // Update source account's balance as well
                    val sourceBalance = hm.getOrDefault(sourceAccountId, 0) - transferredAmount
                    hm[sourceAccountId ?: ""] = sourceBalance.toInt()
                    trans[sourceAccountId ?: ""] =
                        (trans.getOrDefault(sourceAccountId, 0) + transferredAmount).toInt()
                    transfers.remove(transferId)
                    ans.add("true")
                } else {
                    ans.add("false")
                }
            }

            "TOP_ACTIVITY" -> {
                val number = query[2].toInt()
                val sortedKey: List<String> =
                    trans.entries.sortedWith(compareByDescending<Map.Entry<String, Int>> { it.value }.thenBy { it.key })
                        .take(number).map { it.key }
                var transAns: String = ""
                for (i in sortedKey.indices) {
                    transAns = transAns + sortedKey[i] + "(" + trans.getOrDefault(sortedKey[i], 0)
                        .toString() + ")" + ", "
                }
                if (transAns.isNotEmpty()) {
                    transAns = transAns.dropLast(2)
                }
                ans.add(transAns)
            }
        }
    }
    return ans
}
