package com.thainara.notasalunos;

import static java.lang.Double.parseDouble;

public class Aluno {
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

//        double nota = (Double) parseDouble(this.notaAluno);
//        if (nota >= 6){
//            this.statusBoletim = "Aprovadoooo. Boas férias! :D";
//        } else{
//            this.statusBoletim = "Infelizmente você foi reprovado! :(";
//        }
    }

//    public String boletim(String notaAluno){
//        double nota = (Double) parseDouble(notaAluno);
//        String statusNota;
//        if (nota >= 6){
//            statusNota = "Aprovadoooo. Boas férias! :D";
//        } else{
//            statusNota = "Infelizmente você foi reprovado! :(";
//        }
//
//        return statusNota;
//    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
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
