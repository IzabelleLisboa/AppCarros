package com.example.appcarros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MostraCarros extends AppCompatActivity {

    private String[] marcaCarros = new String[]{"BMW", "Ferrari", "Mercedes-Benz", "Porche"};
    private int[] imagens = {R.drawable.bmw, R.drawable.ferrari, R.drawable.mercedes, R.drawable.porche};
    private ImageView imgCarros;
    private TextView marca;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_carros);

        imgCarros = findViewById(R.id.img);
        marca = findViewById(R.id.txtcarro);
        sp = findViewById(R.id.spinner);

        ArrayAdapter<String> valores = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, marcaCarros);
        sp.setAdapter(valores);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imgCarros.setImageResource(imagens[i]);
                marca.setText(sp.getSelectedItem()+"");
                Toast.makeText(MostraCarros.this,sp.getSelectedItem()+"",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void voltarAoMenu(View v){
        Intent it = new Intent(MostraCarros.this,Menu.class);
        startActivity(it);
        finish();
    }

}