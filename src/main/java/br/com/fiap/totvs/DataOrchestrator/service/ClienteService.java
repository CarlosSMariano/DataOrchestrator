package br.com.fiap.totvs.DataOrchestrator.service;

import br.com.fiap.totvs.DataOrchestrator.dao.ClienteDAO;
import br.com.fiap.totvs.DataOrchestrator.model.ClienteInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClienteService {

    @Autowired
    ClienteDAO clienteDAO;

    public void inserirCliente(ClienteInput cliente){
        if (clienteDAO.buscarPorNome(cliente.nome()) != null) throw new RuntimeException("Cliente já cadastrado");
        clienteDAO.insert(cliente);
    }

    public ClienteInput buscarCliente(long id){
        if (!clienteDAO.existePorId(id)) throw new IllegalArgumentException("Cliente inexistente.");
        return clienteDAO.buscarPorID(id);
    }

    public ArrayList<ClienteInput> listarClientes(){
        return clienteDAO.listar();
    }

    public void atualizarCliente(long idCliente, ClienteInput cliente){
        if(!clienteDAO.existePorId(idCliente)) throw new RuntimeException("Cliente inexistente.");
        clienteDAO.atualizar(idCliente, cliente);
    }

    public void deletarCliente(Long id){
        if(!clienteDAO.existePorId(id)) throw new IllegalArgumentException("Cliente inexistente. ");
        clienteDAO.deletar(id);
    }
}
