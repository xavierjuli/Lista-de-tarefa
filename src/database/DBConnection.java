package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    //conecta com o banco
    private static final String URL = "jdbc:sqlite:tarefas.db";

    public static Connection getConnection() {
        Connection conexao = null;

        try{
            conexao=DriverManager.getConnection(URL);
            System.out.println("Conexão realizada com sucesso!");
            return conexao;
        }
        catch(SQLException e){
            System.out.println("Erro na conexão com o banco de dados!" + e.getMessage());
            return null;
        }
    }
}
