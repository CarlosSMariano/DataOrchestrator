package br.com.fiap.totvs.DataOrchestrator.service;

import br.com.fiap.totvs.DataOrchestrator.model.ClienteEntity;
import br.com.fiap.totvs.DataOrchestrator.model.ClienteInput;
import br.com.fiap.totvs.DataOrchestrator.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public ClienteEntity inserirCliente(ClienteInput clienteInput) {
        if (clienteInput == null) {
            throw new IllegalArgumentException("Os dados do cliente não podem ser nulos.");
        }

        if (clienteRepository.findByNome(clienteInput.nome()).isPresent()) {
            throw new RuntimeException("Cliente já cadastrado");
        }

        ClienteEntity novoCliente = new ClienteEntity(
                null,
                clienteInput.nome(),
                clienteInput.dataCadast()
        );

        return clienteRepository.save(novoCliente);
    }

    public ClienteEntity buscarCliente(long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente inexistente."));
    }

    public List<ClienteEntity> listarClientes() {
        return clienteRepository.findAll();
    }

    @Transactional
    public ClienteEntity atualizarCliente(long idCliente, ClienteInput clienteInput) {
        if (clienteInput == null) {
            throw new IllegalArgumentException("Os dados do cliente não podem ser nulos.");
        }

        if (!clienteRepository.existsById(idCliente)) {
            throw new RuntimeException("Cliente inexistente.");
        }

        ClienteEntity clienteAtualizado = new ClienteEntity(
                idCliente,
                clienteInput.nome(),
                clienteInput.dataCadast()
        );

        return clienteRepository.save(clienteAtualizado);
    }

    @Transactional
    public void deletarCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new IllegalArgumentException("Cliente inexistente.");
        }
        clienteRepository.deleteById(id);
    }
}