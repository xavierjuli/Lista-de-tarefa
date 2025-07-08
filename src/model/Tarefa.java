package model;

import java.time.LocalDateTime;

public class Tarefa {
    private int id;
    private String texto;
    private boolean concluida;
    private LocalDateTime dataAlteracao;

    public Tarefa(String texto) {
        this.texto = texto;
        this.concluida = false;
        this.dataAlteracao = LocalDateTime.now();
    }

    public Tarefa(int id, String texto, boolean concluida, LocalDateTime dataAlteracao) {
        this.id = id;
        this.texto = texto;
        this.concluida = concluida;
        this.dataAlteracao = dataAlteracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id= id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto= texto;
        this.dataAlteracao= LocalDateTime.now();
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida= concluida;
        this.dataAlteracao= LocalDateTime.now();
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao=dataAlteracao;
    }

    @Override
    public String toString() {
        return "[" + (isConcluida() ?"X" :" ") + "] "+ texto+ "(Atualizado em: " + dataAlteracao + ")";
    }
}
