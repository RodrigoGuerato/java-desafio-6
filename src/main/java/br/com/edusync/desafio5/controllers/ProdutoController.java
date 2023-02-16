package br.com.edusync.desafio5.controllers;

import br.com.edusync.desafio5.models.Produto;
import br.com.edusync.desafio5.repositories.params.FiltroProdutoParam;
import br.com.edusync.desafio5.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(value = "/novo")
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produtoQueSeraSalvo) {
        Produto prod = produtoService.salvar(produtoQueSeraSalvo);
        return ResponseEntity.ok(prod);
    }

    @GetMapping(value = "/saldo-positivo")
    public ResponseEntity<List<Produto>> listarProdutosComSaldo() {
        return ResponseEntity.ok(produtoService.getProdutoComSaldo());
    }

    @GetMapping(value = "/{produtoId}")
    public ResponseEntity<Produto> getById(@PathVariable Integer produtoId) {
        return ResponseEntity.ok(produtoService.getById(produtoId));
    }
    @GetMapping(value = "/filtro")
    public ResponseEntity<List<Produto>> filtrar(FiltroProdutoParam parametros) {
        return ResponseEntity.ok(produtoService.filtrar(parametros));
    }

}
