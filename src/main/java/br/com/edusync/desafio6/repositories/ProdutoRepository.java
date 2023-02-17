package br.com.edusync.desafio6.repositories;

import br.com.edusync.desafio6.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
