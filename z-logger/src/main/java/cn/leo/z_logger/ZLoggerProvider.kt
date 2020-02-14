package cn.leo.z_logger

import androidx.core.content.FileProvider

/**
 * @author : ling luo
 * @date : 2019-12-03
 */
class ZLoggerProvider : FileProvider() {
    override fun onCreate(): Boolean {
        context?.let {
            CrashLog.init(it)
        }
        return true
    }
}