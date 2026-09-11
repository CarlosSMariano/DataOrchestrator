package br.com.fiap.totvs.DataOrchestrator.service;

import br.com.fiap.totvs.DataOrchestrator.dao.ClienteDAO;
import br.com.fiap.totvs.DataOrchestrator.dao.ReuniaoDAO;
import br.com.fiap.totvs.DataOrchestrator.model.ClienteEntity;
import br.com.fiap.totvs.DataOrchestrator.model.ReuniaoEntity;
import br.com.fiap.totvs.DataOrchestrator.model.ReuniaoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReuniaoService {

    @Autowired
    private ReuniaoDAO reuniaoDAO;

    @Autowired
    private ClienteDAO clienteDAO;

    public void inserirNoBanco(ReuniaoInput reuniaoInput){
        if(reuniaoInput == null){
            throw new IllegalArgumentException("Os dados da reunião não podem ser nulos.");
        }

        if (reuniaoDAO.existePorTitulo(reuniaoInput.idReuniao())){
            throw new IllegalArgumentException("Reunião já cadastrada.");
        }

        if (clienteDAO.buscarPorNome(reuniaoInput.nomeCliente()) != null){
            throw new IllegalArgumentException("Cliente já cadastrado.");
        }

        clienteDAO.insert(reuniaoInput.nomeCliente(), reuniaoInput.dtReuniao());
        ClienteEntity cli = clienteDAO.buscarPorNome(reuniaoInput.nomeCliente());
        reuniaoDAO.inserir(reuniaoInput, cli.id());
    }

    public ArrayList<ReuniaoEntity> listarReunioes(){
       return reuniaoDAO.listar();
    }

    public void deletarReuniao(long id){
        if (reuniaoDAO.existePorId(id)){
            throw new IllegalArgumentException("Reunião inexistente.");
        }

        reuniaoDAO.deletar(id);
    }
}
