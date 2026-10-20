package br.com.fiap.totvs.DataOrchestrator.service;

import br.com.fiap.totvs.DataOrchestrator.model.ClienteEntity;
import br.com.fiap.totvs.DataOrchestrator.model.ReuniaoEntity;
import br.com.fiap.totvs.DataOrchestrator.model.ReuniaoInput;
import br.com.fiap.totvs.DataOrchestrator.repository.ClienteRepository;
import br.com.fiap.totvs.DataOrchestrator.repository.ReuniaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class ReuniaoService {

    @Autowired
    private ReuniaoRepository reuniaoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public ReuniaoEntity inserirNoBanco(ReuniaoInput reuniaoInput) {
        if (reuniaoInput == null) {
            throw new IllegalArgumentException("Os dados da reunião não podem ser nulos.");
        }

        if (reuniaoRepository.existsByTitulo(reuniaoInput.tituloReuniao())) {
            throw new IllegalArgumentException("Reunião já cadastrada.");
        }

        ClienteEntity cliente = buscarOuCriarCliente(reuniaoInput);

        ReuniaoEntity novaReuniao = new ReuniaoEntity(
                null,
                reuniaoInput.tituloReuniao(),
                reuniaoInput.dtReuniao(),
                reuniaoInput.textoTranscricao(),
                reuniaoInput.statusProcesso(),
                null,
                cliente.id()
        );

        return reuniaoRepository.save(novaReuniao);
    }

    public List<ReuniaoEntity> listarReunioes() {
        return reuniaoRepository.findAll();
    }

    public ReuniaoEntity buscarReuniao(long idReuniao) {
        return reuniaoRepository.findById(idReuniao)
                .orElseThrow(() -> new IllegalArgumentException("Reunião inexistente."));
    }

    @Transactional
    public ReuniaoEntity atualizarReuniao(long idReuniao, ReuniaoInput reuniaoInput) {
        if (reuniaoInput == null) {
            throw new IllegalArgumentException("Os dados da reunião não podem ser nulos.");
        }

        if (!reuniaoRepository.existsById(idReuniao)) {
            throw new IllegalArgumentException("Reunião inexistente para atualização.");
        }

        ClienteEntity cliente = buscarOuCriarCliente(reuniaoInput);

        ReuniaoEntity reuniaoAtualizada = new ReuniaoEntity(
                idReuniao,
                reuniaoInput.tituloReuniao(),
                reuniaoInput.dtReuniao(),
                reuniaoInput.textoTranscricao(),
                reuniaoInput.statusProcesso(),
                null,
                cliente.id()
        );

        return reuniaoRepository.save(reuniaoAtualizada);
    }

    @Transactional
    public void deletarReuniao(long id) {
        if (!reuniaoRepository.existsById(id)) {
            throw new IllegalArgumentException("Reunião inexistente.");
        }
        reuniaoRepository.deleteById(id);
    }

    // --- Metodo Auxiliares ---

    private ClienteEntity buscarOuCriarCliente(ReuniaoInput input) {
        return clienteRepository.findByNome(input.nomeCliente())
                .orElseGet(() -> {
                    ClienteEntity novoCliente = new ClienteEntity(null, input.nomeCliente(), input.dtReuniao());
                    return clienteRepository.save(novoCliente);
                });
    }

}