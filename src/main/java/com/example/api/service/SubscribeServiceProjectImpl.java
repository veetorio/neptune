package com.example.api.service;

import com.example.api.model.Pessoa;
import com.example.api.model.Projeto;
import com.example.api.repository.PessoaRepository;
import com.example.api.repository.ProjetosRepository;
import com.example.api.service.interfaces.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubscribeServiceProjectImpl implements SubscribeService {
    @Autowired
    private ProjetosRepository projetosRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Override
    public void subscribe(Long idProjeto, Long idUser) {
        try {
            Pessoa pessoa = pessoaRepository.findById(idUser).orElseThrow();
            Projeto projeto = projetosRepository.findById(idProjeto).orElseThrow();

            pessoa.getProjetos().add(projeto);
            projeto.getInscritos().add(pessoa);

            projetosRepository.save(projeto);
            pessoaRepository.save(pessoa);
        } catch (RuntimeException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
