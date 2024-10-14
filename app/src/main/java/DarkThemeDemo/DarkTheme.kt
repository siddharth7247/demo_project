package DarkThemeDemo

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import com.example.demo.R

class DarkTheme : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var shpEditor: SharedPreferences.Editor

    @SuppressLint("RequiresFeature")
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dark_theam)

        val btnLightTheme = findViewById<Button>(R.id.btnLightTheme)
        val btnDarkTheme = findViewById<Button>(R.id.btnDarkTheme)
        val btnDeviceTheme = findViewById<Button>(R.id.btnDeviceTheme)
        val btnWebview = findViewById<Button>(R.id.btnWebview)
        val webView = findViewById<WebView>(R.id.webView)

        sharedPreferences = getSharedPreferences("theme", MODE_PRIVATE)
        val status = sharedPreferences.getString("theme", "")
        if (status.equals("true")) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else if (status.equals("false")) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        webView.loadUrl("https://medium.com/droid-log/webview-darkening-force-dark-mode-for-web-contents-d76d86ff9efa")
        webView.isForceDarkAllowed = true

        btnDarkTheme.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            shpEditor = sharedPreferences.edit()
            shpEditor.putString("theme", true.toString()).apply()
        }
        btnLightTheme.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            sharedPreferences = getSharedPreferences("theme", MODE_PRIVATE)
            shpEditor = sharedPreferences.edit()
            shpEditor.putString("theme", false.toString()).apply()

        }
        btnDeviceTheme.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            shpEditor = sharedPreferences.edit()
            shpEditor.clear().apply()
        }
        btnWebview.setOnClickListener {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                WebSettingsCompat.setForceDark(webView.settings, WebSettingsCompat.FORCE_DARK_ON)
                WebSettingsCompat.setAlgorithmicDarkeningAllowed(webView.settings, true)
            }
        }
    }
}