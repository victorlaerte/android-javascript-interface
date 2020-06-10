package br.com.poc.javascript.bridge

import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myWebView = findViewById<WebView>(R.id.webview)
        myWebView.settings.javaScriptEnabled = true
        myWebView.addJavascriptInterface(WebAppInterface(), "Android")
        myWebView.loadUrl("file:///android_asset/myhtml.html");
    }
}

class WebAppInterface() {

    @JavascriptInterface
    fun getNativePayload(): String {
        return "Peguei esse payload nativamente"
    }
}
