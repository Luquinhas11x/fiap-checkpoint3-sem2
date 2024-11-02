package br.com.fiap.checkpoint3.repository;

import br.com.fiap.checkpoint3.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    List<Contato> findByNome(String nome);
}
