package cn.leo.z_logger

import android.util.Log

/**
 * @author : ling luo
 * @date : 2020-02-11
 */

internal object ZLogger {

    var level: LoggerLevel = LoggerLevel.PRINT

    fun p(msg: CharSequence?, tag: String = Logger.TAG) {
        printLog(tag, msg, LoggerLevel.PRINT)
    }

    fun v(msg: CharSequence?, tag: String = Logger.TAG) {
        printLog(tag, msg, LoggerLevel.VERBOSE)
    }

    fun d(msg: CharSequence?, tag: String = Logger.TAG) {
        printLog(tag, msg, LoggerLevel.DEBUG)
    }

    fun i(msg: CharSequence?, tag: String = Logger.TAG) {
        printLog(tag, msg, LoggerLevel.INFO)
    }

    fun w(msg: CharSequence?, tag: String = Logger.TAG) {
        printLog(tag, msg, LoggerLevel.WARN)
    }

    fun e(msg: CharSequence?, tag: String = Logger.TAG) {
        printLog(tag, msg, LoggerLevel.ERROR)
    }

    fun a(msg: CharSequence?, tag: String = Logger.TAG) {
        printLog(tag, msg, LoggerLevel.ASSERT)
    }


    private fun printLog(tag: String = Logger.TAG, msg: CharSequence?, loggerLevel: LoggerLevel) {
        if (!isDebug(ZLoggerProvider.context)) {
            return
        }
        if (msg == null) {
            return
        }
        if (loggerLevel.level < level.level) {
            return
        }
        val msgStr = tryToJson(msg)
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

    private fun tryToJson(msg: CharSequence): String {
        val str = msg.toString()
        //查找左大括号
        val left = str.indexOfFirst { it == '{' }
        if (left < 0) {
            return str
        }
        //查找右大括号
        val right = str.indexOfLast { it == '}' }
        if (right < 0) {
            return str
        }
        //边界判断
        if (right < left) {
            return str
        }
        if (right >= str.length){
            return str
        }
        //有左右大括号，提取大括号内容
        val maybeJson = str.subSequence(left, right + 1).toString()
        val json = maybeJson.isJson()
        if (!json) {
            return str
        }
        //格式化其中json
        return str.substring(0, left) + "\n" +
                maybeJson.toJsonFormat() + "\n" +
                str.substring(right + 1)
    }
}