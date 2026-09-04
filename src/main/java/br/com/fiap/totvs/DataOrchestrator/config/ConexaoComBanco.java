package br.com.fiap.totvs.DataOrchestrator.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoComBanco {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521/FREEPDB1";
        String user = "admin";
        String password = "admin";

        return DriverManager.getConnection(url, user, password);
    }
}
