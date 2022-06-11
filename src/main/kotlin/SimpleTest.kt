import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class SimpleTest {
    @Test
//    Always blocks the running thread
    fun myFirstTest() = runBlocking {
        mySuspendFunc(1000)
        Assert.assertEquals(10, 0)
    }
}