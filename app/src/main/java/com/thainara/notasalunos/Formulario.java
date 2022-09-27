package com.thainara.notasalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Formulario extends AppCompatActivity {
    private TextView tituloLista;
    private ListView listaAlunos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        tituloLista = findViewById(R.id.titleLista);
        listaAlunos = findViewById(R.id.listaAlunos);


        Intent intent = getIntent();
        ArrayList<String> lista = intent.getStringArrayListExtra("lista");
//        String lista = intent.getStringExtra("lista");


        ArrayAdapter adapter = new ArrayAdapter<Adapter>(this, R.layout.activity_formulario, i,lista);
        ListView listView = (ListView) findViewById(R.id.listaAlunos);
        listView.setAdapter(adapter);


        Toast.makeText(Formulario.this, "Lista" + listaA,Toast.LENGTH_SHORT).show();

    }
    
}