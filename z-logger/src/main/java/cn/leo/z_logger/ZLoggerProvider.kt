package cn.leo.z_logger

import android.content.Context
import android.support.v4.content.FileProvider

/**
 * @author : ling luo
 * @date : 2019-12-03
 */
internal class ZLoggerProvider : FileProvider() {
    companion object {
        var context: Context? = null
    }

    override fun onCreate(): Boolean {
        context?.let {
            ZLoggerProvider.context = context
            CrashLog.init(it)
        }
        return true
    }
}