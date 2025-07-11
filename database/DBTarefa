package database;

import model.Tarefa;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DBTarefa {
    private final Connection conn;

    //construtor que inicializa conexão e garante que a tabela será criada
    public DBTarefa() {
        this.conn = DBConnection.getConnection();
        criarTabela();
    }

    //criação da tabela se ainda não existir
    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS tarefas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                texto TEXT NOT NULL,
                concluida BOOLEAN NOT NULL DEFAULT false,
                dataAlteracao TEXT NOT NULL
            );
        """;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
            System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }

    //insere uma nova tarefa no banco
    public boolean inserirTarefa(String texto, Boolean concluida, LocalDateTime dataAlteracao) {
        String sql = "INSERT INTO tarefas(texto, concluida, dataAlteracao) VALUES (?, ?, ?)";
        String dataFormatada = formatarData(dataAlteracao);

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, texto);
            stmt.setBoolean(2, concluida);
            stmt.setString(3, dataFormatada);
            stmt.executeUpdate();
            System.out.println("Tarefa inserida!");
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir tarefa: " + e.getMessage());
            return false;
        }
    }

    //atualiza o status da tarefa com base no ID
    public boolean atualizarStatus(int id, boolean status) {
        String sql = "UPDATE tarefas SET concluida = ?, dataAlteracao = ? WHERE id = ?";
        String dataFormatada = formatarData(LocalDateTime.now());

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, status);
            stmt.setString(2, dataFormatada);
            stmt.setInt(3, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar status: " + e.getMessage());
            return false;
        }
    }

    //lista todas as tarefas
    public List<Tarefa> listarTodas() {
        return buscarPorFiltro(null);
    }

    //lista as tarefas pendentes
    public List<Tarefa> listarPendentes() {
        return buscarPorFiltro(false);
    }

    // Lista as tarefas concluídas
    public List<Tarefa> listarConcluidas() {
        return buscarPorFiltro(true);
    }

    // Método privado genérico para busca com filtro
    private List<Tarefa> buscarPorFiltro(Boolean concluidaFiltro) {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefas" + (concluidaFiltro != null ? " WHERE concluida = ?" : "");

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (concluidaFiltro != null) stmt.setBoolean(1, concluidaFiltro);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tarefa tarefa = new Tarefa(
                        rs.getInt("id"),
                        rs.getString("texto"),
                        rs.getBoolean("concluida"),
                        LocalDateTime.parse(rs.getString("dataAlteracao"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                );
                tarefas.add(tarefa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar tarefas: " + e.getMessage());
        }

        return tarefas;
    }

    // formatação da data
    private String formatarData(LocalDateTime data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return data.format(formatter);
    }
}
