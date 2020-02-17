package cn.leo.z_logger

/**
 * @author : ling luo
 * @date : 2020-02-11
 */

internal fun isDebug() = BuildConfig.DEBUG

/**
 * 测试代码段，只有在debug下会执行
 */
internal inline fun debug(block: () -> Unit) {
    if (isDebug()) {
        block()
    }
}

/**
 * 测量代码块运行时间
 */
internal inline fun measureTimeMillis(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - start
}