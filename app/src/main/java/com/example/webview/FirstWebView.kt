package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class FirstWebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_webview)

        val webView = findViewById<WebView>(R.id.web_view)
        webView.loadUrl(url)
    }

    companion object {
        private const val url = "http://192.168.0.11/"
    }
}