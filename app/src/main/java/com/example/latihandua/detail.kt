package com.example.latihandua

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail.*

class detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)

        var intentThatStartedThisActivity = getIntent()


        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            Tampilan(intentThatStartedThisActivity)
        }
    }


    private fun Tampilan(intentThatStartedThisActivity: Intent){
        var partNama = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
        var partDesc = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEMPLATE)
        var partFoto = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER)?.toInt()
        var partWeb = intentThatStartedThisActivity.getStringExtra(Intent.ACTION_PICK)
        var partEmail = intentThatStartedThisActivity.getStringExtra((Intent.ACTION_CALL))
        namaFakul2.text = partNama
        desFakul2.text = partDesc
        web2.text = partWeb
        email.text = partEmail
        if (partFoto != null) {
            fotoUPN2.setImageResource(partFoto)
        }
        web2.setOnClickListener{
            openWeb(partWeb)
        }
        email.setOnClickListener{
            sendEmail(partEmail)
        }
    }
    private fun openWeb(url: String?) {
        val showWebActivity = Intent(this, web::class.java)
        showWebActivity.putExtra(Intent.ACTION_VIEW, url)
        startActivity(showWebActivity)
    }

    private fun sendEmail(email: String?) {
        val mailIntent = Intent(Intent.ACTION_SEND)
        mailIntent.data = Uri.parse("mailto:")
        mailIntent.type = "text/plain"
        mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Do Not Reply")
        mailIntent.putExtra(Intent.EXTRA_TEXT, "Email Testing")
        startActivity(Intent.createChooser(mailIntent, "Select Client"))
    }
}