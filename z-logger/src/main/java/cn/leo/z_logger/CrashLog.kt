package cn.leo.z_logger

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream

/**
 * @author : ling luo
 * @date : 2020-02-12
 */

internal class CrashLog(
    private val context: Context,
    private val defaultUncaughtExceptionHandler: Thread.UncaughtExceptionHandler?
) :
    Thread.UncaughtExceptionHandler {

    companion object {
        fun init(context: Context) {
            Thread.setDefaultUncaughtExceptionHandler(
                CrashLog(
                    context,
                    Thread.getDefaultUncaughtExceptionHandler()
                )
            )
        }
    }

    /**
     * 崩溃信息捕捉
     */
    override fun uncaughtException(t: Thread, e: Throwable) {

        //展示崩溃信息到浏览器
        val msg = getThrowableMsg(e)
        val html = createHtml(msg)
        val file = writeCrashLogToFile(html)
        "app发生crash，请检查日志".toLogE()
        openWebView(file)
        //交给原系统处理
        defaultUncaughtExceptionHandler?.uncaughtException(t, e)
        //退出app
        //Process.killProcess(Process.myPid())
        //exitProcess(10)
    }

    /**
     * 获取崩溃信息文本，非系统类红色高亮
     */
    private fun getThrowableMsg(e: Throwable): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val printStream = PrintStream(byteArrayOutputStream)
        e.printStackTrace(printStream)
        val s = byteArrayOutputStream.toString()
        val split = s.split("\t").toTypedArray()
        val sb = java.lang.StringBuilder()
        for (i in split.indices) {
            var s1 = split[i]
            if (!s1.contains("android.")
                && !s1.contains("androidx.")
                && !s1.contains("java.")
                && s1.contains("at")
                && i > 0
            ) {
                s1 = String.format("<br> <font color='#FF0000'>%s</font>", s1)
            }
            sb.append(s1).append("\t ")
        }
        var string = sb.toString()
        e.message?.let {
            string = string
                .replace(
                    e.message!!,
                    "<br> <font color='#D81B60'>${e.message!!}</font> <br>"
                )
        }
        return string
    }


    /**
     * 创建html
     */
    private fun createHtml(msg: CharSequence): String {
        return StringBuilder()
            .append("<head>\n")
            .append("<meta name=\"viewport\" content=\"width=240, target-densityDpi=device-dpi\"/>\n")
            .append("<meta http-equiv=\"content-type\" content=\"txt/html; charset=utf-8\" />\n")
            .append("</head>\n")
            .append("<html>\n")
            .append("<h3>${context.packageName} Crash Log:</h3>\n")
            .append("$msg \n")
            .append("<br/>\n")
            .append("</html>\n")
            .toString()
    }

    /**
     * 写入崩溃日志到文件
     */
    private fun writeCrashLogToFile(log: String): File {
        val outLogFile = File(context.externalCacheDir, "${context.packageName}_CrashLog.html")
        outLogFile.writeText(log)
        return outLogFile
    }

    /**
     * 在浏览器打开
     */
    private fun openWebView(file: File) {
        val uri = file.getUri()
        val intent = Intent(context, ZLoggerWebView::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_TASK_ON_HOME or Intent.FLAG_ACTIVITY_NEW_TASK
        intent.data = uri
        context.startActivity(intent)
    }

    private fun File.getUri(): Uri {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            FileProvider.getUriForFile(
                context,
                "${context.packageName}.ZLoggerProvider", this
            )
        } else {
            Uri.fromFile(this)
        }
    }

}