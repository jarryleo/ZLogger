package cn.leo.z_logger

import android.util.Log

/**
 * @author : ling luo
 * @date : 2020-02-11
 */

object Logger {
    const val TAG = "ZLogger"

    var level: LoggerLevel = LoggerLevel.PRINT

    fun p(msg: String, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.PRINT)
    }

    fun v(msg: String, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.VERBOSE)
    }

    fun d(msg: String, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.DEBUG)
    }

    fun i(msg: String, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.INFO)
    }

    fun w(msg: String, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.WARN)
    }

    fun e(msg: String, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.ERROR)
    }

    fun a(msg: String, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.ASSERT)
    }


    private fun printLog(msg: String, tag: String = TAG, loggerLevel: LoggerLevel) {
        if (!isDebug()) {
            return
        }
        if (loggerLevel.level < level.level) {
            return
        }
        val msgStr = if (msg.isJson()) {
            " \n${msg.toJsonFormat()}"
        } else {
            msg
        }
        when (loggerLevel) {
            LoggerLevel.PRINT -> println(msgStr)
            LoggerLevel.VERBOSE -> Log.v(tag, msgStr)
            LoggerLevel.DEBUG -> Log.d(tag, msgStr)
            LoggerLevel.INFO -> Log.i(tag, msgStr)
            LoggerLevel.WARN -> Log.w(tag, msgStr)
            LoggerLevel.ERROR -> Log.e(tag, msgStr)
            LoggerLevel.ASSERT -> Log.wtf(tag, msgStr)
            else -> return
        }
    }
}