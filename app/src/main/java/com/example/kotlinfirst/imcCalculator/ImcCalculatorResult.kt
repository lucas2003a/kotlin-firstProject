package com.example.kotlinfirst.imcCalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinfirst.R
import com.example.kotlinfirst.imcCalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ImcCalculatorResult : AppCompatActivity() {

    private lateinit var tvResult       : TextView
    private lateinit var tvIMC          : TextView
    private lateinit var tvDescription  : TextView
    private lateinit var tvTitleText    : TextView
    private lateinit var btnRecalculate : Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val result : Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0;
        initComponents();
        initUI(result);
        initListeners();
    }

    private fun initListeners(){

        btnRecalculate.setOnClickListener {
            onBackPressedDispatcher.onBackPressed();
        }
    }

    private fun initUI(result :Double){

        tvTitleText.text = getString(R.string.textResult, result.toString());

        when(result){

            //Bajo peso
            in 0.00..18.5 ->{
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.textColorUnderWeight));
                tvResult.text            = getString(R.string.underWeightError);
                tvDescription.text       = getString(R.string.underWeightDescription);
                tvIMC.text               = getString(R.string.underWeightMessage);
            }

            //Peso normal
            in 18.51..24.99 ->{
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.textColorSuccessWeight));
                tvResult.text           = getString(R.string.weightSuccess);
                tvDescription.text      = getString(R.string.weightSuccessDescription);
                tvIMC.text              = getString(R.string.weightSuccessDescriptionMessage);
            }

            //Sobrepeso
            in 25.00..29.99 ->{
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.textColorOverWeight));
                tvResult.text           = getString(R.string.overWeightError);
                tvDescription.text      = getString(R.string.overWeightDescription);
                tvIMC.text              = getString(R.string.overWeightDescriptionMessage);
            }

            //Obesidad
            in 30.00..99.00 ->{
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.textColorObesity));
                tvResult.text           = getString(R.string.obesityError);
                tvDescription.text      = getString(R.string.obesityDescription);
                tvIMC.text              = getString(R.string.obesityDescriptionMessage);
            }
            //Error
            else ->{
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.textColorError));
                tvIMC.text          = getString(R.string.error)
                tvResult.text       = getString(R.string.errorDescription)
                tvDescription.text  = getString(R.string.errorDescription)
            }
        }
    }

    private fun initComponents(){

        tvIMC           = findViewById(R.id.tvIMC);
        tvResult        = findViewById(R.id.tvResult);
        tvDescription   = findViewById(R.id.tvDescription);
        tvTitleText     = findViewById(R.id.tvTitleText);
        btnRecalculate  = findViewById(R.id.btnRecalculate);
    }
}