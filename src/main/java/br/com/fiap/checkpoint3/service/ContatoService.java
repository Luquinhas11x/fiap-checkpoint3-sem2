package br.com.fiap.checkpoint3.service;

import br.com.fiap.checkpoint3.repository.ContatoRepository;
import br.com.fiap.checkpoint3.model.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> list() {
        return contatoRepository.findAll();
    }

    public Contato save(Contato cliente) {
        return contatoRepository.save(cliente);
    }

    public boolean existsById(Long id) {
        return contatoRepository.existsById(id);
    }

    public void delete(Long id) {
        contatoRepository.deleteById(id);
    }

    public Optional<Contato> findById(Long id) {
        return contatoRepository.findById(id);
    }

    public List<Contato> findByNome(String nome){
        return contatoRepository.findByNome(nome);
    }
}
