package br.com.fiap.totvs.DataOrchestrator.dao;

import br.com.fiap.totvs.DataOrchestrator.config.ConexaoComBanco;
import br.com.fiap.totvs.DataOrchestrator.model.ReuniaoEntity;
import br.com.fiap.totvs.DataOrchestrator.model.ReuniaoInput;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class ReuniaoDAO {

    public void inserir(ReuniaoInput reuniao) {
        String insert = "INSERT INTO REUNIAO (TITULO_REUN, DATA_REUN, TEXT_TRANS, STATUS_PROCESS, CLIENTE_ID_CLI) VALUES (?, ?, ?, ?, ?)";

        System.out.println(reuniao.idReuniao()+"\n"+reuniao.dtReuniao()+"\n"+reuniao.statusProcesso()+"\n"+reuniao.nomeCliente());
        try(Connection conn = ConexaoComBanco.getConnection()){

            PreparedStatement stmt = conn.prepareStatement(insert);
            stmt.setString(1, reuniao.idReuniao());
            stmt.setDate(2, reuniao.dtReuniao());
            stmt.setString(3, reuniao.textoTranscricao());
            stmt.setString(4, reuniao.statusProcesso());

            stmt.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException("Erro ao inserir dados na tabela REUNIAO: "+ e);
        }
    }

    public boolean existePorTitulo(String titulo){
        String query = "SELECT COUNT(*) FROM REUNIAO WHERE TITULO_REUN = ?";

        try (Connection conn = ConexaoComBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, titulo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar existência da reunião pelo titulo.", e);
        }
        return false;
    }

    public boolean existePorId(long id){
        String query = "SELECT COUNT(*) FROM REUNIAO WHERE ID_REUN = ?";

        try (Connection conn = ConexaoComBanco.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar existência da reunião pelo id.", e);
        }
        return false;
    }

    public ArrayList<ReuniaoEntity> listar(){
        String query = "SELECT * FROM REUNIAO";
        ArrayList<ReuniaoEntity> reunioes = new ArrayList<>();

        try(Connection conn = ConexaoComBanco.getConnection() ;
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery()){

            while (rs.next()){
                ReuniaoEntity reuniao = new ReuniaoEntity(
                        rs.getLong("ID_REUN"),
                        rs.getString("TITULO_REUN"),
                        rs.getTimestamp("DATA_REUN").toLocalDateTime(),
                        rs.getString("TEXT_TRANS"),
                        rs.getString("STATUS_PROCESS"),
                        rs.getDouble("RISCO_CHURN"),
                        rs.getString("CLIENTE_ID_CLI")
                );
                reunioes.add(reuniao);
            }


        }catch(SQLException e){
            throw new RuntimeException("Erro ao listar dados da tabela REUNIAO: ", e);
        }

        return reunioes;
    }

    public void deletar(long id){
        String query = "DELETE FROM REUNIAO WHERE ID_REUN = ?";

        try{
            Connection conn = ConexaoComBanco.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar dados da tabela REUNIAO: ", e);
        }
    }
}
