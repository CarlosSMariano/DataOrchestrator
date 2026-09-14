package br.com.fiap.totvs.DataOrchestrator.dao;

import br.com.fiap.totvs.DataOrchestrator.config.ConexaoComBanco;
import br.com.fiap.totvs.DataOrchestrator.model.ClienteEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class ClienteDAO {

    public void insert(ClienteEntity cliente){
        String query = "INSERT INTO CLIENTE (NOME_CLI, DATA_CADAST) VALUES (?, ?)";

        try(Connection conn = ConexaoComBanco.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, cliente.nome());
            stmt.setDate(2, cliente.dataCadast());
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

    public ClienteEntity buscarPorID(long id){
        String query = "SELECT * FROM CLIENTE WHERE ID_CLI = ?";

        try(Connection conn = ConexaoComBanco.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setLong(1, id);
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

    public ArrayList<ClienteEntity> listar(){
        String query = "SELECT * FROM CLIENTE";

        ArrayList<ClienteEntity> clientes = new ArrayList<>();

        try(Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery()){

            while(rs.next()){
                ClienteEntity cliente = new ClienteEntity(
                  rs.getLong("ID_CLI"),
                  rs.getString("NOME_CLI"),
                  rs.getDate("DATA_CADAST") != null ? Date.valueOf(rs.getDate("DATA_CADAST").toLocalDate()) : null
                );
                clientes.add(cliente);
            }
        }catch(SQLException e){
            throw new RuntimeException("Erro ao listar dados da tabela Cliente" + e);
        }
        return clientes;
    }

    public boolean existePorId(Long id) {
        String query = "SELECT COUNT(ID_CLI) FROM CLIENTE WHERE ID_CLI = ?";

        try(Connection conn = ConexaoComBanco.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setLong(1, id);

            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Erro ao buscar cliente por ID: " + e);
        }
        return false;
    }

    public void atualizar(long id, ClienteEntity cliente){
        String query = "UPDATE CLIENTE SET NOME_CLI = ?, DATA_CADAST = ? WHERE ID_CLI = ?";

        try(Connection conn = ConexaoComBanco.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, cliente.nome());
            stmt.setDate(2, cliente.dataCadast());
            stmt.setLong(3, id);
            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao inserir dados na tabela Cliente: " + e);
        }
    }

    public void deletar(long id) {
        String query = "DELETE FROM CLIENTE WHERE ID_CLI = ?";

        try (Connection conn = ConexaoComBanco.getConnection()) {
            conn.setAutoCommit(false);

            try{
               new ReuniaoDAO().deletarPorCliente(id, conn);

                try(PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setLong(1, id);
                    stmt.executeUpdate();
                }
                conn.commit();

            }catch (SQLException e){
                conn.rollback();
                throw new RuntimeException("Erro ao deletar cliente e suas reuniões: " + e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar cliente: ", e);
        }
    }


}
