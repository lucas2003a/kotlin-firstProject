package com.example.kotlinfirst

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinfirst.firtsApp.FirstAppActivity
import com.example.kotlinfirst.firtsApp.MainActivity
import com.example.kotlinfirst.imcCalculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnFirstApp         = findViewById<AppCompatButton>(R.id.btnFirstApp);
        val btnSaludarApp       = findViewById<AppCompatButton>(R.id.btnSaludarApp);
        val btnIMCCalulatorApp  = findViewById<AppCompatButton>(R.id.btnImcCalculatorApp);

        btnFirstApp.setOnClickListener { navigateToApp(FirstAppActivity::class.java) };
        btnSaludarApp.setOnClickListener { navigateToApp(MainActivity::class.java) };
        btnIMCCalulatorApp.setOnClickListener { navigateToApp(ImcCalculatorActivity::class.java) };
    }

    private fun navigateToApp(activityClass: Class<*>){
        val intent = Intent(this,activityClass);
        startActivity(intent);
    }

    private fun navigateToFirstApp(){
        val intent = Intent(this, FirstAppActivity::class.java);
        startActivity(intent);
    }
}