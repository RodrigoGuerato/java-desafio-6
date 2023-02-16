package br.com.edusync.desafio5.repositories;

import br.com.edusync.desafio5.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
