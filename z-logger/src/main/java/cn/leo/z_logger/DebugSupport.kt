package cn.leo.z_logger

import android.content.Context
import android.content.pm.ApplicationInfo

/**
 * @author : ling luo
 * @date : 2020-02-11
 */

internal fun isDebug(context: Context?): Boolean {
    return try {
        context?.applicationInfo?.flags ?: 0 and ApplicationInfo.FLAG_DEBUGGABLE != 0
    } catch (e: Exception) {
        false
    }
}

/**
 * 测量代码块运行时间
 */
inline fun measureTimeMillis(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    return System.currentTimeMillis() - start
}