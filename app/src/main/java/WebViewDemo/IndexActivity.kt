package WebViewDemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.R


class IndexActivity : AppCompatActivity() {
    lateinit var btnWebView : Button
    lateinit var btnWebViewHtml : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index2)

        btnWebView = findViewById(R.id.btnWebView)
        btnWebViewHtml =  findViewById(R.id.btnWebViewHtml)
        btnWebView.setOnClickListener{
            intent = Intent(this,WebViewDemoActivity::class.java)
            intent.putExtra("activity","webView")
            startActivity(intent)
        }
        btnWebViewHtml.setOnClickListener{
            intent = Intent(this,WebViewDemoActivity::class.java)
            intent.putExtra("activity","webViewHtml")
            startActivity(intent)
        }

    }
}