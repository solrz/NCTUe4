package com.team214.nctue4

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.team214.nctue4.login.LoginActivity
import com.team214.nctue4.main.MainActivity

class LandingActivity : AppCompatActivity() {
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoActionBar)  //End Splash Screen
        super.onCreate(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)

        prefs.edit().putInt("versionCode", packageManager.getPackageInfo(packageName, 0).versionCode).apply()

        val studentId = prefs.getString("studentId", null)
        val studentPassword = prefs.getString("studentPassword", null)
        val studentPortalPassword = prefs.getString("studentPortalPassword", null)
        val token = prefs.getString("newE3Token", null)
        val userId = prefs.getString("newE3UserId", null)
        val studentName = prefs.getString("studentName", null)
        val studentEmail = prefs.getString("studentEmail", null)

        val intent =
            if (studentId == null ||
                studentPassword == null ||
                studentPortalPassword == null ||
                token == null ||
                userId == null ||
                studentName == null ||
                studentEmail == null
            ) {
                Intent(this, LoginActivity::class.java)
            } else {
                Intent(this, MainActivity::class.java)
            }
        startActivity(intent)
        finish()
    }
}
