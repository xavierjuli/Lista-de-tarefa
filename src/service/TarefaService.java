package database;

import model.Tarefa;

import java.time.LocalDateTime;
import java.util.List;

public class TarefaService {
    private final DBTarefa tarefaDB;

    public TarefaService() {
            this.tarefaDB = new DBTarefa();
        }

    public boolean criarTarefa(String texto) {
        if (texto == null || texto.isBlank()) return false;
        return tarefaDB.inserirTarefa(texto, false, LocalDateTime.now());
    }

    public boolean atualizarStatus(int id, boolean status) {
        return tarefaDB.atualizarStatus(id, status);
    }

    public List<Tarefa> listarTodas() {
            return tarefaDB.listarTodas();
        }

    public List<Tarefa> listarPendentes() {
            return tarefaDB.listarPendentes();
        }

    public List<Tarefa> listarConcluidas() {
            return tarefaDB.listarConcluidas();
        }

}
