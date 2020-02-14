package cn.leo.z_logger

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_zlogger_web_view.*

class ZLoggerWebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zlogger_web_view)
        zLoggerWeb.webViewClient = WebViewClient()
        zLoggerWeb.webChromeClient = WebChromeClient()
        val data = intent.data
        val url = data?.toString()
        url?.let {
            zLoggerWeb.loadUrl(it)
        }
    }
}
