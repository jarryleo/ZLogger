package cn.leo.zlogger

import cn.leo.z_logger.isJson
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testJson() {
        println("{123".isJson())
        println("{\"approvalStatus\":1,\"commentCount\":2}".isJson())
    }
}
