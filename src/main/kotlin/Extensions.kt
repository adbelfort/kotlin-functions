import java.time.Clock
import java.time.Instant
import java.util.UUID
import kotlin.random.Random

fun FuryClient.getToken(user: String, password: String): String = this.createSession(user, password).token.toString()

fun main() {
    // Prepare
    val sessionIdProvider = { Random(Instant.now().epochSecond).nextLong() }
    val tokenProvider = UUID::randomUUID
    val clock = Clock.systemUTC()

    // Instantiate the client and the service
    val client = FuryClient(sessionIdProvider, tokenProvider, clock)
    val service = FuryService()

    // Get token
    val token = client.getToken("someuser", "somepassword")

    // Use token
    service.update(token, "KVS")
}