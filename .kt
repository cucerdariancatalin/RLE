fun encodeRLE(data: String): String {
    val sb = StringBuilder()
    var count = 1
    var prevChar = data[0]
    for (i in 1 until data.length) {
        val currChar = data[i]
        if (currChar == prevChar) {
            count++
        } else {
            sb.append("$count$prevChar")
            count = 1
            prevChar = currChar
        }
    }
    sb.append("$count$prevChar")
    return sb.toString()
}

fun decodeRLE(data: String): String {
    val sb = StringBuilder()
    var count = 0
    for (c in data) {
        if (c.isDigit()) {
            count = count * 10 + (c - '0')
        } else {
            sb.append(c.toString().repeat(count))
            count = 0
        }
    }
    return sb.toString()
}
