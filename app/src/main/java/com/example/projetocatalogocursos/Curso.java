package com.example.projetocatalogocursos;

public class Curso {

    String nome;
    float cargaHoraria;
    int conceito;
    int tipo;

    public Curso(String nome, float cargaHoraria, int conceito, int tipo) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.conceito = conceito;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getConceito() {
        return conceito;
    }

    public void setConceito(int conceito) {
        this.conceito = conceito;
    }

    public int getTipo() {
        return tipo;
    }
    
    public String getTipoLiteral(){
        String retorno = "";
        if (this.tipo == 1){
            retorno = "Tecnólogo";
        } else if(this.tipo == 2){
            retorno = "Bacharelado";
        } else{
            retorno = "Licenciatura";
        }
        return retorno;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
