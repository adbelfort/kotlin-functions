import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.ZoneOffset
import java.util.UUID
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FuryClientTest {
    @Test
    fun `createSession creates a new session`() {
        // Given
        val sessionIdProvider = { 123L }
        val expectedToken = UUID.fromString("2d59d104-d148-4ba9-bc34-60fbc17c6fc5")
        val tokenProvider = { expectedToken }

        val now = Instant.now()

        val clock = Clock.fixed(now, ZoneOffset.UTC)

        val client = FuryClient(sessionIdProvider, tokenProvider, clock)

        // When
        val session = client.createSession("test", "🤝🚀🌈🤓🙌")

        // Then
        session.sessionId.shouldBe(123L)
        session.user shouldBe "test"
        session.token shouldBe expectedToken
        session.createdAt shouldBe now
        session.expiresAt shouldBe (now + Duration.ofHours(12))
    }
}

infix fun <T> T?.shouldBe(expected: T?) {
    Assertions.assertEquals(expected, this)
}