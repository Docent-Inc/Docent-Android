package com.docent

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import com.docent.databinding.ActivityMainBinding


class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var webView: WebView
    private val url = "https://docent.zip/loginpage"

    @SuppressLint("SetJavaScriptEnabled")
    override fun initAfterBinding() {
        webView = binding.webView;
        webView.loadUrl(url);

        webView.settings.javaScriptEnabled = true
        webView.addJavascriptInterface(JavaScriptInterface(this), "Android")
        webView.webViewClient = webViewClient

        // TODO: 크롬 인스펙터 확인
        WebView.setWebContentsDebuggingEnabled(true);
    }

    private val webViewClient: WebViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }
    }
}