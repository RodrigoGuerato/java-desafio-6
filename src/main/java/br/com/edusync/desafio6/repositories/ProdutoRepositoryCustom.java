package br.com.edusync.desafio6.repositories;

import br.com.edusync.desafio6.models.Produto;
import br.com.edusync.desafio6.repositories.params.FiltroProdutoParam;

import java.util.List;

public interface ProdutoRepositoryCustom {

    public List<Produto> getFiltro(FiltroProdutoParam params);

}
