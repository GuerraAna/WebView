package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView

class SecondWebView : AppCompatActivity() {

    lateinit var textView: TextView

    @JavascriptInterface
    fun conseguirFraseDoDia(frase: String) {
        textView.text = frase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_webview)

        val webView = WebView(this)
        webView.settings.javaScriptEnabled = true
        webView.addJavascriptInterface(this, name)

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                webView.loadUrl(javaScriptUrl)
            }
        }

        webView.loadUrl(url)
    }

    companion object {
        private const val name = "jsi"
        private const val javaScriptUrl = "\"javascript:jsi.conseguirFraseDoDia(document.getElementByClassName(\\\"frase_do_dia\\\")[0].textContent\""
        private const val url = "http://192.168.0.11/"
    }
}