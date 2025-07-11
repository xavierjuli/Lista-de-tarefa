package GUI;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Tarefa;
import service.TarefaService;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class MenuController {
    @FXML
    private TextField campoNovaTarefa;

    @FXML
    private TableView<Tarefa> tabelaTarefas;

    @FXML
    private TableColumn<Tarefa, Integer> colId;

    @FXML
    private TableColumn<Tarefa, String> colTexto;

    @FXML
    private TableColumn<Tarefa, String> colStatus;

    @FXML
    private TableColumn<Tarefa, String> colData;
    private final TarefaService tarefaService = new TarefaService();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private final MarcarConcluidaController marcarConcluida = new MarcarConcluidaController(tarefaService);


    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTexto.setCellValueFactory(new PropertyValueFactory<>("texto"));

        colStatus.setCellValueFactory(cellData -> {
            boolean concluida = cellData.getValue().isConcluida();
            String status = concluida ? "Concluída" : "Pendente";
            return new ReadOnlyStringWrapper(status);
        });

        colData.setCellValueFactory(cellData -> {
            if (cellData.getValue().getDataAlteracao() != null) {
                String formatted = cellData.getValue().getDataAlteracao().format(formatter);
                return new ReadOnlyStringWrapper(formatted);
            } else {
                return new ReadOnlyStringWrapper("");
            }
        });

        filtrarTodas();
    }

    private void carregarTarefas(List<Tarefa> tarefas) {
        tabelaTarefas.getItems().setAll(tarefas);
    }


    @FXML
    public void adicionarTarefa() {
        String descricao = campoNovaTarefa.getText();

        if (descricao == null || descricao.isBlank()) {
            System.out.println("Erro: descrição vazia");
            return;
        }

        if (tarefaService.criarTarefa(descricao)) {
            campoNovaTarefa.clear();
            filtrarTodas();
        } else {
            System.out.println("Erro ao adicionar a tarefa");
        }
    }


    @FXML
    public void filtrarTodas() {
        List<Tarefa> lista = tarefaService.listarTodas();
        carregarTarefas(lista);
        System.out.println("Filtro: Todas");
    }

    @FXML
    public void filtrarPendentes() {
        List<Tarefa> lista = tarefaService.listarPendentes();
        carregarTarefas(lista);
        System.out.println("Filtro: Pendentes");
    }

    @FXML
    public void filtrarConcluidas() {
        List<Tarefa> lista = tarefaService.listarConcluidas();
        carregarTarefas(lista);
        System.out.println("Filtro: Concluídas");
    }

    @FXML
    public void marcarConcluida() {
        Tarefa selecionada = tabelaTarefas.getSelectionModel().getSelectedItem();
        if (selecionada == null) {
            System.out.println("Nada selecionado");
            return;
        }

        boolean sucesso = marcarConcluida.marcarConcluida(selecionada);

        if (sucesso) {
            System.out.println("Tarefa '" + selecionada.getTexto() + "' concluída.");
            filtrarTodas();
        } else {
            System.out.println("Erro!");}
    }
}
