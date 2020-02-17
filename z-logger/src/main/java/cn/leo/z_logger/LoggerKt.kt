package cn.leo.z_logger

/**
 * @author : ling luo
 * @date : 2020-02-11
 */

fun CharSequence.toLogD(tag: String = Logger.TAG) {
    ZLogger.d(this, tag)
}

fun CharSequence.toLogI(tag: String = Logger.TAG) {
    ZLogger.i(this, tag)
}

fun CharSequence.toLogE(tag: String = Logger.TAG) {
    ZLogger.e(this, tag)
}

fun CharSequence.toLogW(tag: String = Logger.TAG) {
    ZLogger.w(this, tag)
}

fun CharSequence.toLogV(tag: String = Logger.TAG) {
    ZLogger.v(this, tag)
}

fun Any.logE(log: CharSequence, tag: String = Logger.TAG) {
    ZLogger.e(log, tag)
}

fun Any.logW(log: CharSequence, tag: String = Logger.TAG) {
    ZLogger.w(log, tag)
}

fun Any.logD(log: CharSequence, tag: String = Logger.TAG) {
    ZLogger.d(log, tag)
}

fun Any.logI(log: CharSequence, tag: String = Logger.TAG) {
    ZLogger.i(log, tag)
}

fun Any.logV(log: CharSequence, tag: String = Logger.TAG) {
    ZLogger.v(log, tag)
}