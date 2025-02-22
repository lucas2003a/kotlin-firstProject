package com.example.kotlinfirst.imcCalculator

import android.app.backup.BackupAgent
import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinfirst.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected      : Boolean  = true;
    private var isFemaleSelected    : Boolean  = false;
    private var currentWeight        : Int      = 60;
    private var currentAge           : Int      = 10;
    private var currentHeight        : Int      = 120;

    private lateinit var viewFemale         : CardView;
    private lateinit var viewMale           : CardView;
    private lateinit var rngSliderHeight    : RangeSlider;
    private lateinit var tvHeight           : TextView;
    private lateinit var tvWeight           : TextView;
    private lateinit var tvAge              : TextView;
    private lateinit var btnSubtractWeight  : FloatingActionButton;
    private lateinit var btnPlusWeight      : FloatingActionButton;
    private lateinit var btnSubtractAge     : FloatingActionButton;
    private lateinit var btnPlusAge         : FloatingActionButton;
    private lateinit var btnCalculateIMC    : Button;

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    };

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents();
        initListeners();
    }

    private fun initComponents(){
        viewMale            = findViewById(R.id.viewMale);
        viewFemale          = findViewById(R.id.viewFemale);
        tvHeight            = findViewById(R.id.tvHeight);
        tvWeight            = findViewById(R.id.tvWeight);
        tvAge               = findViewById(R.id.tvAge);
        rngSliderHeight     = findViewById(R.id.rngSliderHeight);
        btnSubtractWeight   = findViewById(R.id.btnSubtractWeight);
        btnPlusWeight       = findViewById(R.id.btnPlusWeight);
        btnSubtractAge      = findViewById(R.id.btnSubtractAge);
        btnPlusAge          = findViewById(R.id.btnPlusAge);
        btnCalculateIMC     = findViewById(R.id.calculateIMC);
    }

    private fun initListeners(){
        viewMale.setOnClickListener{
            changeGeneder();
            setGenderColor();
        };

        viewFemale.setOnClickListener {
            changeGeneder();
            setGenderColor();
        };

        rngSliderHeight.addOnChangeListener{_, value,_ ->
            val decimalFormat = DecimalFormat("#.##");
            currentHeight = decimalFormat.format(value).toInt();
            tvHeight.text = getString(R.string.heightFormat, currentHeight.toString());
        };

        btnSubtractWeight.setOnClickListener{
            subtractWeight();
        };

        btnPlusWeight.setOnClickListener{
            plusWeight();
        };

        btnSubtractAge.setOnClickListener {
            subtractAge();
        };

        btnPlusAge.setOnClickListener {
            plusAge();
        }

        btnCalculateIMC.setOnClickListener {
            calculateIMC();         //  calculate the IMC
            navigateToImcResult();  //  go to result
        }
    }

    private fun navigateToImcResult(){
        val imcResult = calculateIMC();
        val intent = Intent(this, ImcCalculatorResult :: class.java);
        intent.putExtra(IMC_KEY, imcResult);
        startActivity(intent);
    }
    private fun calculateIMC() : Double {

        val df = DecimalFormat("#.##");
        val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100);
        val result = df.format(imc).toDouble();
        Log.i("Lucas","El IMC es $imc") //Log
        showMessage("El cálculo del IMC es $result") //Toast
        return result;
    }

    private fun changeGeneder(){
        isMaleSelected = !isMaleSelected;
        isFemaleSelected = !isFemaleSelected;
    }

    private fun setGenderColor(){
        viewMale.setBackgroundColor(getBackgroundColor(isMaleSelected));
        viewFemale.setBackgroundColor(getBackgroundColor(isFemaleSelected));
    }

    private fun getBackgroundColor(isSelectedComponent : Boolean) : Int {

        val colorReference = if(isSelectedComponent){
             R.color.background_component_selected
         }else{
             R.color.background_component
         }

        return ContextCompat.getColor(this,colorReference);
    }

    private fun plusWeight(){
        currentWeight++;
        setWeight();
    }

    private fun subtractWeight(){
        if(currentWeight > 10){
            currentWeight--;
            setWeight();
        }else{
            showMessage("El peso mínimo es 10 kg.");
        }
    }

    private fun showMessage(message : String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    private fun setWeight(){
        tvWeight.text = this.currentWeight.toString();
    }

    private fun plusAge(){
        currentAge++;
        setAge();
    }

    private fun subtractAge(){
        if(currentAge > 10){
            currentAge--;
            setAge();
        }else{
            showMessage("La edad mínima es 10 años.");
        }
    }

    private fun setAge(){
        tvAge.text = this.currentAge.toString();
    }

    private fun initUI(){
        setGenderColor();
        setWeight();
    }
}