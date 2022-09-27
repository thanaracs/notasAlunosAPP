package com.thainara.notasalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// Activity do relatório
public class Formulario extends AppCompatActivity implements AddDialogRelatorio.BtnOpcoes {
    private TextView tituloLista;
    private ListView listaAlunos;
    private Adapter adapter;
    ArrayList<Aluno> alunosList;
    int escolhaFinalOpcaoDialog;
    int posicaoAlunoSelecionadoDialog;
    ProgressBar progressBar;
    Handler handler = new Handler();
    int gerenciamentoTempo = 0;
    TableLayout tabelaAlunos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        tituloLista = findViewById(R.id.titleLista);
        listaAlunos = findViewById(R.id.listaAlunos);
        Intent intent = getIntent();
        progressBar = findViewById(R.id.carregar);
        alunosList = (ArrayList<Aluno>) intent.getSerializableExtra("lista");
        adapter = new Adapter(getApplicationContext(), alunosList );
        listaAlunos.setAdapter(adapter);
        tabelaAlunos = findViewById(R.id.tableList);


        // ProgressBar
        new Thread(new Runnable() {
            public void run() {
                while (gerenciamentoTempo < 100) {
                    gerenciamentoTempo += 25;
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(gerenciamentoTempo);
                            if(gerenciamentoTempo==100){
                                tabelaAlunos.setVisibility(View.VISIBLE);
                                progressBar.setVisibility(View.INVISIBLE);
                                listaAlunos.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



//        Toast.makeText(Formulario.this, "Lista" + alunosList,Toast.LENGTH_SHORT).show();

        //Instanciando a caixa de dialog
        listaAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AddDialogRelatorio caixaDialogo = new AddDialogRelatorio();
                caixaDialogo.show(getSupportFragmentManager(), "texto");
                posicaoAlunoSelecionadoDialog = position;
            }
        });

    }

    // Progressbar
    public void progress(){

    }


    //dialog
    @Override
    public void opcao(int opcaoSelecionada) {
        escolhaFinalOpcaoDialog = opcaoSelecionada;
        excluirAluno(posicaoAlunoSelecionadoDialog);
    }

    public void excluirAluno(int posicaoAluno){
        if (escolhaFinalOpcaoDialog == 1){
            alunosList.remove(posicaoAluno);
            //chamando novamente a listView
            adapter = new Adapter(getApplicationContext(), alunosList );
            listaAlunos.setAdapter(adapter);
            Toast.makeText(Formulario.this, "O aluno foi deletado da lista",Toast.LENGTH_SHORT).show();
        }
    }
}