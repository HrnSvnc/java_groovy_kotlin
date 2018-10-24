import com.google.gson.Gson
import java.io.File
import java.net.URI
import java.net.URL
import java.net.URLEncoder
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

// JSON response to yoda translator
// https://funtranslations.com/api/yoda
//
// {
//    "success": {
//        "total": 1
//    },
//    "contents": {
//        "translation": "yoda",
//        "text": "Master Obiwan has lost a planet.",
//        "translated": "<translated text>"
//    }
// }

data class YodaResponse(val success: YodaSuccess,
                        val contents: YodaContents)

data class YodaSuccess(val total: Int)

data class YodaContents(val translation: String,
                        val text: String,
                        val translated: String)

const val base = "https://api.funtranslations.com/translate/yoda.json?"

fun String.yoda(): YodaResponse {
    val key = File("src/main/resources/api_key.txt").readText()
    val qs = "text=${URLEncoder.encode(this, "UTF-8")}"

    val client = HttpClient.newBuilder().build()

    val request = HttpRequest.newBuilder()
            .uri(URI.create("$base$qs"))
            .header("X-FunTranslations-Api-Secret", key)
            .GET()
            .build()

    val response = client.send(request, HttpResponse.BodyHandlers.ofString())

    return Gson().fromJson(response.body(), YodaResponse::class.java)
}

fun main() {
    File("src/main/resources/strings.txt").readLines()
            .map { it.yoda().contents.translated }
            .forEach { println(it) }
}