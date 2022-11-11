package com.example.appcarros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class VerPaises extends AppCompatActivity {
    private String[] paises = new String[]{"Brasil", "Canadá", "Alemanha", "Grecia"};
    private int[] imagens = {R.drawable.br, R.drawable.cn, R.drawable.gr, R.drawable.grece};
    private String[] Capital = new String[]{"Brasilia ", "Ottawa", "Berlim", " Atenas"};
    private String[] Habitantes= new String[]{"213 milhões", "38,25 milhões", "83,13 milhões", "10,66 milhões"};
    private String[] LinguaOficial = new String[]{"Português ", "Francês,Inglês", "Alemão", "Grego"};
    private String[] Moeda = new String[]{"Real", "Dólar canadiano", "Euro", "Euro"};

    private ImageView imgPaises;
    private TextView Paises;
    private TextView Cap;
    private TextView Habi;
    private TextView LinguaOf;
    private TextView MoedaUsada;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_paises);

        imgPaises = findViewById(R.id.imgp);
        Paises = findViewById(R.id.txtpaises);
        Cap= findViewById(R.id.txtcapital);
        Habi= findViewById(R.id.txthabi);
        LinguaOf= findViewById(R.id.txtlingua);
        MoedaUsada=findViewById(R.id.txtmoeda);
        sp = findViewById(R.id.spinner2);

        ArrayAdapter<String> valores = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,paises);
        sp.setAdapter(valores);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imgPaises.setImageResource(imagens[i]);
                Paises.setText(sp.getSelectedItem()+"");
                Cap.setText("Capital:"+Capital[i]);
                Habi.setText("Habitantes:"+Habitantes[i]);
                LinguaOf.setText("Lingua Oficial:"+LinguaOficial[i]);
                MoedaUsada.setText("Moeda:"+Moeda[i]);
                Toast.makeText(VerPaises.this,sp.getSelectedItem()+"",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void voltarAoMenu(View v){
        Intent it = new Intent(VerPaises.this,Menu.class);
        startActivity(it);
        finish();
    }


    }
