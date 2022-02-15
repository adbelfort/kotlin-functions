import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.util.UUID

class FuryClient(
    private val sessionIdProvider: () -> Long,
    private val tokenProvider: () -> UUID,
    private val clock: Clock,
) {
    fun createSession(user: String, password: String): FurySession {
        require(password.isNotBlank()) { "Password must not be blank" }

        return FurySession(
            sessionId = sessionIdProvider(),
            user = user,
            token = tokenProvider(),
            createdAt = clock.instant(),
        )
    }
}

data class FurySession(
    val sessionId: Long,
    val user: String,
    val token: UUID,
    val createdAt: Instant,
    val expiresAt: Instant = createdAt + Duration.ofHours(12),
)

class FuryService {
    fun update(token: String, resource: String) {
        println("Resource $resource updated (with token $token)")
    }
}