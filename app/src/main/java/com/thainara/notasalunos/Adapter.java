package com.thainara.notasalunos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// classe responsável por formar a lista de alunos e jogar na tela

public class Adapter extends BaseAdapter {
    ArrayList<Aluno> arrayAlunos;
    LayoutInflater layoutInflater;  //preencher um layout


    public Adapter(Context context, ArrayList<Aluno> arrayAlunos) {
        this.arrayAlunos = arrayAlunos;
        layoutInflater = LayoutInflater.from(context);

    }// construtor


    @Override
    public int getCount() {
        return arrayAlunos.size();
    }// retorna o tamanho do array

    @Override
    public Object getItem(int position) {
        return arrayAlunos.get(position);
    }// retorna a posicao do objeto da lista

    @Override
    public long getItemId(int position) {
        return position;
    }// retorna o id

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Aluno aluno = arrayAlunos.get(position);

        view = layoutInflater.inflate(R.layout.lista_personalizada, null);
        TextView nomeAluno = view.findViewById(R.id.nomeAluno);
        TextView status = view.findViewById(R.id.status);
        TextView notaAluno = view.findViewById(R.id.notaAluno);

        nomeAluno.setText(aluno.getNomeAluno());
        status.setText(aluno.getStatusBoletim());
        notaAluno.setText(aluno.getNotaAluno());

        return view;
    }// montando a tela
}
