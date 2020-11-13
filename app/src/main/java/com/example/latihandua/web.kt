package com.example.latihandua

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.web.*

class web : AppCompatActivity() {
    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web)
        val webView = webView
        val intentThatStartedThisActivity = getIntent()

        if (intentThatStartedThisActivity.hasExtra(Intent.ACTION_VIEW)){
            var url = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_VIEW)

            webView.loadUrl(url.toString())

            webView.webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                }

                override fun onPageFinished(view: WebView, url: String) {
                }
            }

        }}

    override fun onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack()
        }
    }
}
