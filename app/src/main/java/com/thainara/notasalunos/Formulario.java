package com.thainara.notasalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// Activity do relatório
public class Formulario extends AppCompatActivity {
    private TextView tituloLista;
    private ListView listaAlunos;
    private Adapter adapter;
    ArrayList<Aluno> alunosList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        tituloLista = findViewById(R.id.titleLista);
        listaAlunos = findViewById(R.id.listaAlunos);

        Intent intent = getIntent();
        alunosList = (ArrayList<Aluno>) intent.getSerializableExtra("lista");
        adapter = new Adapter(getApplicationContext(), alunosList );
        listaAlunos.setAdapter(adapter);

        Toast.makeText(Formulario.this, "Lista" + alunosList,Toast.LENGTH_SHORT).show();

    }
    
}