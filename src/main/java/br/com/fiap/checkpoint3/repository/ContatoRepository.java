package br.com.fiap.checkpoint3.repository;

import br.com.fiap.checkpoint3.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
    <T> T findByNome(String nome, Class<T> type);
    <T> List<T> findAllByNome(String nome, Class<T> type);
    <T> List<T> findAllByNomeContains(String nome, Class<T> type);
}
