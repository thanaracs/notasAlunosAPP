package com.thainara.notasalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText nomeAluno, nota;
    private RadioButton rbCurso, rbOutros;
    private Spinner spinnerMaterias;
    private Button btnEnviar;
    private ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomeAluno = findViewById(R.id.nomeAluno);
        rbCurso = findViewById(R.id.rbSistemas);
        rbOutros = findViewById(R.id.rbOutros);
        spinnerMaterias = findViewById(R.id.spinnerSistemas);
        nota = findViewById(R.id.nota);
        btnEnviar = findViewById(R.id.btnEnviar);

        //radioButton Sistemas para internet
        rbCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerMaterias.setVisibility(View.VISIBLE);
                adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.maters ,android.R.layout.simple_spinner_item);//new ArrayAdapter<CharSequence>(MainActivity.this,android.R.layout.simple_spinner_item, materias);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerMaterias.setAdapter(adapter);

            }
        });
        spinnerMaterias.setOnItemSelectedListener(this);

        //radioButton Outros
        rbOutros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerMaterias.setVisibility(View.INVISIBLE);
            }
        });

        //ADICIONANDO O PROGRESSBAR APÓS CLICAR NO BOTÃO ENVIAR.
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnEnviar.setVisibility(View.VISIBLE);

            }
        });


    } //onCreate

    //Mostrando matéria selecionada
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String materia = (String) adapterView.getItemAtPosition(i);
        Toast.makeText(MainActivity.this, "item: " + materia,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        spinnerMaterias.setVisibility(View.INVISIBLE);
    }

    //Inserir nota
    public void validacaoNota(){

    }


}