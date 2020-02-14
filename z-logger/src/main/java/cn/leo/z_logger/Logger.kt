package cn.leo.z_logger

import android.util.Log

/**
 * @author : ling luo
 * @date : 2020-02-11
 */

object Logger {
    const val TAG = "ZLogger"

    var level: LoggerLevel = LoggerLevel.PRINT

    fun p(msg: CharSequence?, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.PRINT)
    }

    fun v(msg: CharSequence?, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.VERBOSE)
    }

    fun d(msg: CharSequence?, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.DEBUG)
    }

    fun i(msg: CharSequence?, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.INFO)
    }

    fun w(msg: CharSequence?, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.WARN)
    }

    fun e(msg: CharSequence?, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.ERROR)
    }

    fun a(msg: CharSequence?, tag: String = TAG) {
        printLog(tag, msg, LoggerLevel.ASSERT)
    }


    private fun printLog(tag: String = TAG, msg: CharSequence?, loggerLevel: LoggerLevel) {
        if (!isDebug()) {
            return
        }
        if (msg == null) {
            return
        }
        if (loggerLevel.level < level.level) {
            return
        }
        val str = msg.toString()
        val msgStr = if (str.isJson()) {
            " \n${str.toJsonFormat()}"
        } else {
            str
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