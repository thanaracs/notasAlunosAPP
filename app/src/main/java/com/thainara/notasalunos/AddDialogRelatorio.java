package com.thainara.notasalunos;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class AddDialogRelatorio extends DialogFragment {
    private BtnOpcoes btnOpcoes;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Relatório")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("Deseja excluir o item da lista?")
                .setPositiveButton("sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int sim = 1;
                        btnOpcoes.opcao(sim);
                    }
                })
                .setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int nao = 0;
                        btnOpcoes.opcao(nao);
                    }
                });
        return builder.create();
    }

    // Classe de interface para gerenciar os botoes
    public interface BtnOpcoes{
        void opcao (int opcaoSelecionada);
    }

    // Tratamento de erro
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            btnOpcoes = (BtnOpcoes) context;
        } catch (ClassCastException classCastException) {
            throw new ClassCastException(context.toString() + "error 404.");
        }
    }

}

