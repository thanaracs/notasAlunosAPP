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
import android.widget.Switch;
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
    CharSequence charSequence = "11";


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
                nota.setVisibility(View.VISIBLE);
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
                nota.setVisibility(View.INVISIBLE);
                spinnerMaterias.setVisibility(View.INVISIBLE);
                curso = rbOutros.getText().toString();
                materia = "Materia não informada.";
                nota.setText(charSequence);
//                if(nota == null){
//                    int notaValueOthers = 0;
//                    Toast.makeText(MainActivity.this, "nota:" + nota, Toast.LENGTH_SHORT);
//                }
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
                    if ((notaa >= 6) && (notaa <= 10)) {
                        statusBoletim = "Aprovado";

                    }else if(notaa == 11){
                        CharSequence charSequence = "0";
                        nota.setText(charSequence);
                        statusBoletim = "Sem matricula.";
                    } else {
                        statusBoletim = "reprovado";
                    }
                    Aluno aluno = new Aluno(nomeAluno.getText().toString(), nota.getText().toString(), curso, materia, statusBoletim);
                    alunos.add(aluno);
//                Toast.makeText(MainActivity.this, "Adicionado Aluno: " +alunos, Toast.LENGTH_SHORT).show();
                    if (alunos.size() >= 3) {
                        btnEnviar.setEnabled(true);
                    }
                    nomeAluno.setText("");
                    nota.setText("");
                    rbCurso.setChecked(false);
                    rbOutros.setChecked(false);
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