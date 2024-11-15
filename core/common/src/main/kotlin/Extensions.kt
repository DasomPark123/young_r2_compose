import java.util.regex.Pattern

fun String.removeKorean(): String {
    val regex = "[\\uAC00-\\uD7A3]".toRegex()
    return this.replace(regex, "")
}

fun String.findWordBetweenBracket(): String {
    var word : String? = ""
    val pattern = Pattern.compile("[(](.*?)[)]")
    val matcher = pattern.matcher(this)
    while (matcher.find()) {
        word = matcher.group(1)
        if (word == null) break
    }
    return word ?: ""
}