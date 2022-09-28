package com.thainara.notasalunos;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText nomeAluno, nota;
    private RadioButton rbCurso, rbOutros;
    private Spinner spinnerMaterias;
    private Button btnEnviar, btnAdicionar;
    private ArrayAdapter<CharSequence> adapter;
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    String curso = "";
    String materia = "", statusBoletim = "";


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
        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnEnviar.setEnabled(false);  //bloqueando botão enviar

        //radioButton Sistemas para internet
        rbCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerMaterias.setVisibility(View.VISIBLE);

                adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.maters ,
                        android.R.layout.simple_spinner_item);
                //new ArrayAdapter<CharSequence>(MainActivity.this,android.R.layout.simple_spinner_item, materias);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerMaterias.setAdapter(adapter);
                curso = rbCurso.getText().toString();

            }
        });
        spinnerMaterias.setOnItemSelectedListener(this);

        //radioButton Outros
        rbOutros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerMaterias.setVisibility(View.INVISIBLE);
                curso = rbOutros.getText().toString();
                materia = "Materia não informada.";
            }
        });
        // Botão para adicionar alunos
        btnAdicionar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nomeString = nomeAluno.getText().toString();
                String notaString = nota.getText().toString();
                if(nomeString.isEmpty() || notaString.isEmpty()){
                    Toast.makeText(MainActivity.this, "Informe dados do aluno!", Toast.LENGTH_SHORT).show();
                }
                else {
                    double notaa = (Double) parseDouble(nota.getText().toString());
                    if (notaa >= 6) {
                        statusBoletim = "Aprovado";
                    } else {
                        statusBoletim = "reprovado";
                    }
                    Aluno aluno = new Aluno(nomeAluno.getText().toString(), nota.getText().toString(), curso, materia, statusBoletim);
                    alunos.add(aluno);
//                Toast.makeText(MainActivity.this, "Adicionado Aluno: " +alunos, Toast.LENGTH_SHORT).show();
                    if (alunos.size() >= 3) {
                        btnEnviar.setEnabled(true);
                    }
                }
            }
        });

        //ADICIONANDO O PROGRESSBAR APÓS CLICAR NO BOTÃO ENVIAR.
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                Toast.makeText(MainActivity.this, "pipipi: " +alunos, Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(), Formulario.class);
                it.putExtra("lista", alunos);
                startActivity(it);

            }
        });

    } //onCreate

    //Mostrando matéria selecionada
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String it = (String) spinnerMaterias.getItemAtPosition(i);
        materia=it;
//        materia = (String) adapterView.getItemAtPosition(i);
//        Toast.makeText(MainActivity.this, "item: " + materia,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //spinnerMaterias.setVisibility(View.INVISIBLE);
    }
    //Inserir nota
    public void validacaoNota(){
    }








}