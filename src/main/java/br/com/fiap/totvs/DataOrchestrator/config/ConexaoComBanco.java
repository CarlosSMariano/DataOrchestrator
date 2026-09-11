package br.com.fiap.totvs.DataOrchestrator.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoComBanco {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
    private static final String USER = "admin_totvs";
    private static final String PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {

        try{
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão efetuada com sucesso!");
            return conn;

        }catch(SQLException e){
            throw new SQLException("Erro ao conectar ao banco de dados:" + e.getMessage());
        }
    }
}
