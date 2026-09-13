package br.com.fiap.totvs.DataOrchestrator.service;

import br.com.fiap.totvs.DataOrchestrator.dao.ClienteDAO;
import br.com.fiap.totvs.DataOrchestrator.model.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;

@Service
public class ClienteService {

    @Autowired
    ClienteDAO clienteDAO;

    public void inserirCliente(ClienteEntity cliente){
        if (clienteDAO.buscarPorNome(cliente.nome()) != null) throw new RuntimeException("Cliente já cadastrado");
        clienteDAO.insert(cliente.nome(), cliente.dataCadast());
    }

    public ClienteEntity buscarCliente(long id){
        if (!clienteDAO.existePorId(id)) throw new IllegalArgumentException("Cliente inexistente.");
        return clienteDAO.buscarPorID(id);
    }

    public ArrayList<ClienteEntity> listarClientes(){
        return clienteDAO.listar();
    }

    public void deletarCliente(Long id){
        if(!clienteDAO.existePorId(id)) throw new IllegalArgumentException("Cliente inexistente. ");
        clienteDAO.deletar(id);
    }
}
