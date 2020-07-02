package cn.leo.z_logger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_zlogger_web_view.*

internal class ZLoggerWebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zlogger_web_view)
        zLoggerWeb.webViewClient = WebViewClient()
        zLoggerWeb.webChromeClient = WebChromeClient()
        with(zLoggerWeb.settings) {
            setSupportZoom(true)
            builtInZoomControls = true
            displayZoomControls = false
            useWideViewPort = true
            layoutAlgorithm = WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING
            loadWithOverviewMode = true
        }
        val data = intent.data
        val url = data?.toString()
        url?.let {
            zLoggerWeb.loadUrl(it)
        }
    }
}
