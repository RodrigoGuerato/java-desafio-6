package br.com.edusync.desafio5.repositories;

import br.com.edusync.desafio5.models.MovimentoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentoEstoqueRepository extends JpaRepository<MovimentoEstoque, Integer> {
    public List<MovimentoEstoque> findByProdutoId(Integer produto);
}
