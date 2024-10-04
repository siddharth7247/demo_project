package WebViewDemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.R


class WebViewDemoActivity : AppCompatActivity() {
    lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_demo)


        var bundle: Bundle? = intent.extras
        var activity: String = bundle?.get("activity").toString()
        webView = findViewById(R.id.webView)
        Log.d("Activity", "${activity}")

        if (activity == "webView") {
            webView.loadUrl("https://developer.android.com")
            webView.webViewClient = WebViewClient()
            webView.settings.javaScriptEnabled = true
            webView.canGoBack()

        } else {
            var form = "<html><body><center><h1>hello,WebView Demo</h1></center></body></html>"
            webView.loadData(form, "text/html", "UTF8")
        }
    }

    override fun onBackPressed() {

        if (webView.canGoBack()) {
            webView.goBack()
        } else
            super.onBackPressed()
    }
}