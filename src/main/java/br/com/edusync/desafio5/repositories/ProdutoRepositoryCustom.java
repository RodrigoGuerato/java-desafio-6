package br.com.edusync.desafio5.repositories;

import br.com.edusync.desafio5.models.Produto;
import br.com.edusync.desafio5.repositories.params.FiltroProdutoParam;

import java.util.List;

public interface ProdutoRepositoryCustom {

    public List<Produto> getFiltro(FiltroProdutoParam params);

}
