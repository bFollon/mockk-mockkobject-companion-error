import io.kotest.matchers.ints.shouldBeExactly
import io.mockk.every
import io.mockk.mockkObject
import org.junit.jupiter.api.Test

class ClassWithCompanionTest {

    @Test
    fun mockkShouldReplaceTheCompanionInstance() {

        mockkObject(ClassWithCompanion.Companion)

        val instanceToBeReturnedByMock = BasicClass("mockk")

        every { ClassWithCompanion.Companion.staticValue } returns instanceToBeReturnedByMock

        val underTest = ClassWithCompanion()

        println("Hash code and parameter from test")
        println("Companion hash code: ${ClassWithCompanion.hashCode()}")
        println("Static value hash code: ${ClassWithCompanion.staticValue.hashCode()}")
        println("Parameter: ${ClassWithCompanion.staticValue.parameter}")

        println("------------------------------")

        underTest.printClassHashAndParameter()

        ClassWithCompanion.staticValue.hashCode() shouldBeExactly instanceToBeReturnedByMock.hashCode()
        underTest.getCompanionHash() shouldBeExactly instanceToBeReturnedByMock.hashCode()
    }
}