package br.com.edusync.desafio5.controllers;

import br.com.edusync.desafio5.models.MovimentoEstoque;
import br.com.edusync.desafio5.models.dto.MovtoEstoqueRequestDTO;
import br.com.edusync.desafio5.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<MovimentoEstoque> movimentarEstoque(@RequestBody MovtoEstoqueRequestDTO request) {
        MovimentoEstoque mvto = estoqueService.movimentarEstoque(request);
        return ResponseEntity.ok(mvto);
    }

    @GetMapping(value = "/{produtoId}/historico")
    public ResponseEntity<List<MovimentoEstoque>> listarHistorico(@PathVariable Integer produtoId) {
        return ResponseEntity.ok(estoqueService.listarHistorico(produtoId));
    }




}
