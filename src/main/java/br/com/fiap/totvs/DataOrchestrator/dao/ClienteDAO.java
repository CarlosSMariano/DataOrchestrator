package br.com.fiap.totvs.DataOrchestrator.dao;

import br.com.fiap.totvs.DataOrchestrator.config.ConexaoComBanco;
import br.com.fiap.totvs.DataOrchestrator.model.ClienteEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.*;

@Repository
public class ClienteDAO {

    public void insert(String nomeCliente, Date dataCadastro){
        String query = "INSERT INTO CLIENTE (NOME_CLI, DATA_CADAST) VALUES (?, ?)";

        try(Connection conn = ConexaoComBanco.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, nomeCliente);
            stmt.setDate(2, dataCadastro);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao inserir dados na tabela Cliente: " + e);
        }
    }

    public ClienteEntity buscarPorNome(String nomeCliente){
        String query = "SELECT * FROM CLIENTE WHERE NOME_CLI = ?";

        try(Connection conn = ConexaoComBanco.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, nomeCliente);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ClienteEntity(
                        rs.getLong("ID_CLI"),
                        rs.getString("NOME_CLI"),
                        rs.getDate("DATA_CADAST") != null ? Date.valueOf(rs.getDate("DATA_CADAST").toLocalDate()) : null
                );
            }

        }catch (SQLException e){
            throw new RuntimeException("Erro ao buscar cliente por nome: " + e);
        }
        return null;
    }
}
