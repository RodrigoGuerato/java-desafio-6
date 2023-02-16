package br.com.edusync.desafio5.services;

import br.com.edusync.desafio5.models.Produto;
import br.com.edusync.desafio5.repositories.ProdutoRepository;
import br.com.edusync.desafio5.repositories.ProdutoRepositoryCustom;
import br.com.edusync.desafio5.repositories.params.FiltroProdutoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoRepositoryCustom produtoRepositoryCustom;

    public Produto salvar(Produto produtoQueSeraSalvo) {
        produtoQueSeraSalvo.setSaldoAtual(0);
        return produtoRepository.save(produtoQueSeraSalvo);
    }

    public Produto getById(Integer id) {
        return produtoRepository.findById(id).get();
    }

    public List<Produto> getProdutoComSaldo() {
        List<Produto> listaDeProdutosComSaldo = new ArrayList<>();
        List<Produto> listaDeProdutos = produtoRepository.findAll();
        for (Produto prod : listaDeProdutos) {
            if (prod.getSaldoAtual() != null && prod.getSaldoAtual() > 0) {
                listaDeProdutosComSaldo.add(prod);
            }
        }
        return listaDeProdutosComSaldo;
    }

    public List<Produto> filtrar(FiltroProdutoParam params) {
        return produtoRepositoryCustom.getFiltro(params);
    }




}
