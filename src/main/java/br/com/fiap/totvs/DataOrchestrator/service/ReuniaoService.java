package br.com.fiap.totvs.DataOrchestrator.service;

import br.com.fiap.totvs.DataOrchestrator.dao.ReuniaoDAO;
import br.com.fiap.totvs.DataOrchestrator.model.ReuniaoEntity;
import br.com.fiap.totvs.DataOrchestrator.model.ReuniaoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReuniaoService {

    @Autowired
    private ReuniaoDAO reuniaoDAO;

    public void inserirNoBanco(ReuniaoInput reuniaoInput){
        if(reuniaoInput == null){
            throw new IllegalArgumentException("Os dados da reunião não podem ser nulos.");
        }

        if (reuniaoDAO.existePorTitulo(reuniaoInput.idReuniao())){
            throw new IllegalArgumentException("Reunião já cadastrada.");
        }

        reuniaoDAO.inserir(reuniaoInput);
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
