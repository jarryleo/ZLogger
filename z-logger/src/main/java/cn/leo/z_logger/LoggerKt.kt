package cn.leo.z_logger

/**
 * @author : ling luo
 * @date : 2020-02-11
 */

fun String.toLogD(tag: String = Logger.TAG) {
    Logger.d(tag, this)
}

fun String.toLogI(tag: String = Logger.TAG) {
    Logger.i(tag, this)
}

fun String.toLogE(tag: String = Logger.TAG) {
    Logger.e(tag, this)
}

fun String.toLogW(tag: String = Logger.TAG) {
    Logger.w(tag, this)
}

fun String.toLogV(tag: String = Logger.TAG) {
    Logger.v(tag, this)
}

fun Any.logE(log: String, tag: String = Logger.TAG) {
    Logger.e(tag, log)
}

fun Any.logW(log: String, tag: String = Logger.TAG) {
    Logger.w(tag, log)
}

fun Any.logD(log: String, tag: String = Logger.TAG) {
    Logger.d(tag, log)
}

fun Any.logI(log: String, tag: String = Logger.TAG) {
    Logger.i(tag, log)
}

fun Any.logV(log: String, tag: String = Logger.TAG) {
    Logger.v(tag, log)
}