package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.TarefaService;

public class AdicionarController {
    private final TarefaService tarefaService = new TarefaService();

    public boolean salvarTarefa(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            mostrarErro("Descrição inválida!");
            return false;
        }

        boolean sucesso = tarefaService.criarTarefa(descricao);

        if (sucesso) {
            mostrarJanelaSucesso();
        } else {
            mostrarErro("Erro ao salvar no banco");
        }

        return sucesso;
    }

    private void mostrarJanelaSucesso() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/Adicionar.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Mensagem");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            mostrarErro("Erro ao exibir mensagem");
        }
    }

    public void mostrarErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    @FXML
    private Button okButton;

    @FXML
    public void fechar() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
}
