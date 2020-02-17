package cn.leo.z_logger;


import org.jetbrains.annotations.Nullable;

/**
 * @author : ling luo
 * @date : 2020-02-17
 */
public class Logger {

    public static String TAG = "ZLogger";

    public static void debuggable(boolean debug) {
        ZLogger.INSTANCE.setLevel(debug ? LoggerLevel.PRINT : LoggerLevel.CLOSE);
    }

    public static void level(LoggerLevel level) {
        ZLogger.INSTANCE.setLevel(level);
    }


    public static void v(String tag, @Nullable CharSequence msg) {
        ZLogger.INSTANCE.v(msg,tag);
    }

    public static void d(String tag, @Nullable CharSequence msg) {
        ZLogger.INSTANCE.d(msg,tag);
    }

    public static void i(String tag, @Nullable CharSequence msg) {
        ZLogger.INSTANCE.i(msg,tag);
    }

    public static void w(String tag, @Nullable CharSequence msg) {
        ZLogger.INSTANCE.w(msg,tag);
    }

    public static void e(String tag, @Nullable CharSequence msg) {
        ZLogger.INSTANCE.e(msg,tag);
    }

    public static void v(@Nullable CharSequence msg) {
        ZLogger.INSTANCE.v(msg,TAG);
    }

    public static void d(@Nullable CharSequence msg) {
        ZLogger.INSTANCE.d(msg,TAG);
    }

    public static void i(@Nullable CharSequence msg) {
        ZLogger.INSTANCE.i(msg,TAG);
    }

    public static void w(@Nullable CharSequence msg) {
        ZLogger.INSTANCE.w(msg,TAG);
    }

    public static void e(@Nullable CharSequence msg) {
        ZLogger.INSTANCE.e(msg,TAG);
    }
}
