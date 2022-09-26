package com.thainara.notasalunos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Formulario extends AppCompatActivity {
    private TextView pipipi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        pipipi = findViewById(R.id.titleLista);
    }
}