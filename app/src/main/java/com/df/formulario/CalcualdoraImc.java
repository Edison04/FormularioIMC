package com.df.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalcualdoraImc extends AppCompatActivity implements View.OnClickListener {

    private TextView tvInformation;
    private TextView tvRestult;
    private EditText txtHeight;
    private EditText txtWeight;
    private Button btnCalculator;
    private ImageView imState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcualdora_imc);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String surname = intent.getStringExtra("surname");
        String email = intent.getStringExtra("email");
        String message = "INFORMATION" +"\nHola " + name + " " + surname
                + " es un gusto tenerte acá.\nSu correo para el informe es:\n" + email;
        tvInformation = findViewById(R.id.tvInformation);
        tvRestult = findViewById(R.id.tvResult);
        txtHeight = findViewById(R.id.txtHeight);
        txtWeight = findViewById(R.id.txtWeight);
        btnCalculator = findViewById(R.id.btnCalculator);
        imState = findViewById(R.id.imState);
        tvInformation.setText(message);
        btnCalculator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalculator) {
            double height = Double.parseDouble(String.valueOf(txtHeight.getText()));
            double weight = Double.parseDouble(String.valueOf(txtWeight.getText()));
            this.getImc(weight, height);
        }
    }

    private void getImc(double weight, double height) {
        double imc = weight / Math.pow(height, 2);
        DecimalFormat dc = new DecimalFormat("#.00");
        if (imc < 18.5) {
            imState.setImageResource(R.drawable.pesobajo);
            tvRestult.setText("RESULT" +"\nSu IMC es: " + dc.format(imc)
                    + "\nPor lo que usted tiene:\nBAJO PESO");
        } else if (imc < 25) {
            imState.setImageResource(R.drawable.pesonormal);
            tvRestult.setText("RESULT" +"\nSu IMC es: " + dc.format(imc)
                    + "\nPor lo que usted tiene:\nPESO NORMAL");
        } else if (imc < 30) {
            imState.setImageResource(R.drawable.sobrepeso);
            tvRestult.setText("RESULT" +"\nSu IMC es: " + dc.format(imc)
                    + "\nPor lo que usted tiene:\nSOBREPESO");
        } else if (imc < 35) {
            imState.setImageResource(R.drawable.obesidad);
            tvRestult.setText("RESULT" +"\nSu IMC es: " + dc.format(imc)
                    + "\nPor lo que usted tiene:\nOBECIDAD");
        } else if (imc < 40) {
            imState.setImageResource(R.drawable.obecidadsevera);
            tvRestult.setText("RESULT" +"\nSu IMC es: " + dc.format(imc)
                    + "\nPor lo que usted tiene:\nOBECIDAD SEVERA");
        } else if (imc >= 40) {
            imState.setImageResource(R.drawable.obecidadmorbida);
            tvRestult.setText("RESULT" +"\nSu IMC es: " + dc.format(imc)
                    + "\nPor lo que usted tiene OBECIDAD MORBIDA");
        }
    }
}
