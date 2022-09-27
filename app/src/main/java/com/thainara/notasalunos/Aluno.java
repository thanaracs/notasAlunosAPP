package com.thainara.notasalunos;

import static java.lang.Double.parseDouble;

import java.io.Serializable;

// Class responsável por formar o objeto aluno
public class Aluno implements Serializable {
    String nomeAluno;
    String notaAluno;
    String cursoSitemas;
    String materias;
    String statusBoletim = "";

    public Aluno(String nomeAluno, String notaAluno, String cursoSitemas, String materias, String statusBoletim) {
        this.nomeAluno = nomeAluno;
        this.notaAluno = notaAluno;
        this.cursoSitemas = cursoSitemas;
        this.materias = materias;
        this.statusBoletim = statusBoletim;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getStatusBoletim(){
        return  statusBoletim;
    }

    public String getNotaAluno() {
        return notaAluno;
    }

    public void setNotaAluno(String notaAluno) {
        this.notaAluno = notaAluno;
    }

    public String getCursoSitemas() {
        return cursoSitemas;
    }

    public void setCursoSitemas(String cursoSitemas) {
        this.cursoSitemas = cursoSitemas;
    }

    public String getMaterias() {
        return materias;
    }

    public void setMaterias(String materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nomeAluno='" + nomeAluno + '\'' +
                ", notaAluno='" + notaAluno + '\'' +
                ", cursoSitemas='" + cursoSitemas + '\'' +
                ", materias='" + materias + '\'' +
                ", statusBoletim='" + statusBoletim + '\'' +
                '}';
    }
}
