package cn.leo.z_logger

/**
 * @author : ling luo
 * @date : 2020-02-12
 */
enum class LoggerLevel(val level: Int) {
    PRINT(0),
    VERBOSE(1),
    DEBUG(2),
    INFO(3),
    WARN(4),
    ERROR(5),
    ASSERT(6),
    CLOSE(9)
}