package com.example.appcarros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Conversor extends AppCompatActivity {
    private String[] tipoV = new String[]{"Kg=Quilograma", "g=Grama", "Mg=Miligrama", "T=Toneladas"};

    private TextView ValorEntrada;
    private TextView ValorSaida;
    private Spinner sp1;
    private Spinner sp2;
    private int op1,op2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);


        ValorEntrada= findViewById(R.id.txtValorini);
        ValorSaida= findViewById(R.id.txtValorConvertido);
        sp1=findViewById(R.id.spinnerA);
        sp2=findViewById(R.id.spinnerB);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,tipoV);
        sp1.setAdapter(adapter1);
        sp2.setAdapter(adapter1);


    }
    //----Converter Valores

public void calcular(View v) {


    op1 = sp1.getSelectedItemPosition();
    op2 = sp2.getSelectedItemPosition();
    double resultado = Double.parseDouble(ValorEntrada.getText().toString());

    switch (op1) {
        case 0:
            switch (op2) {
                case 0:
                    ValorSaida.setText(resultado + " Kg");
                    break;
                case 1:
                    ValorSaida.setText(resultado * 1000 + " g");
                    break;
                case 2:
                    ValorSaida.setText(resultado * 1000000 + " mg");
                    break;
                case 3:
                    ValorSaida.setText(resultado * 0.001 + " Ton");
                    break;
            }
            break;

        case 1:
            switch (op2) {
                case 0:
                    ValorSaida.setText(resultado * 0.001 +" Kg");
                    break;
                case 1:
                    ValorSaida.setText(resultado + " g");
                    break;
                case 2:
                    ValorSaida.setText(resultado *1000 + " mg");
                    break;
                case 3:
                    ValorSaida.setText(resultado * 0.000001 + " Ton");
                    break;
            }
            break;

        case 2:
            switch (op2) {
                case 0:
                    ValorSaida.setText(resultado * 0.000001 +" Kg");
                    break;
                case 1:
                    ValorSaida.setText(resultado *1000 + " g");
                    break;
                case 2:
                    ValorSaida.setText(resultado + " mg");
                    break;
                case 3:
                    ValorSaida.setText(resultado * 0.000000001 + " Ton");
                    break;
            }
            break;

        case 3:
            switch (op2) {
                case 0:
                    ValorSaida.setText(resultado * 1000 +" Kg");
                    break;
                case 1:
                    ValorSaida.setText(resultado *1000000 + " g");
                    break;
                case 2:
                    ValorSaida.setText(resultado * 1000000000 +" mg");
                    break;
                case 3:
                    ValorSaida.setText(resultado + " Ton");
                    break;
            }
            break;
    }
}
    public  void Voltar(View v){
        Intent it = new Intent(Conversor.this,Menu.class);
        startActivity(it);
        finish();
    }
}


