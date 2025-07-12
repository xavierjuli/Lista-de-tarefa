package GUI;

import model.Tarefa;
import database.TarefaService;

public class MarcarConcluidaController {

    private final TarefaService tarefaService;

    public MarcarConcluidaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    public boolean marcarConcluida(Tarefa tarefa) {
        if (tarefa == null || tarefa.isConcluida()) {
            System.out.println("Não foi possível fazer essa operação");
            return false;
        }

        boolean sucesso = tarefaService.atualizarStatus(tarefa.getId(), true);

        if (sucesso) {
            tarefa.setConcluida(true);
        }

        return sucesso;
    }
}
