package br.com.edusync.desafio5.services;

import br.com.edusync.desafio5.models.MovimentoEstoque;
import br.com.edusync.desafio5.models.Produto;
import br.com.edusync.desafio5.models.dto.MovtoEstoqueRequestDTO;
import br.com.edusync.desafio5.repositories.MovimentoEstoqueRepository;
import br.com.edusync.desafio5.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private MovimentoEstoqueRepository estoqueRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public MovimentoEstoque movimentarEstoque(MovtoEstoqueRequestDTO request) {
        Produto prod = produtoRepository.findById(request.getProdutoId()).get();
        MovimentoEstoque mvto = new MovimentoEstoque();
        mvto.setDataHora(LocalDateTime.now());
        mvto.setProduto(prod);
        mvto.setQuantidade(request.getQuantidade());
        mvto.setTipoMovimento(request.getTipoMovimento());
        MovimentoEstoque mvtoSalvo = estoqueRepository.save(mvto);

        // Atualiza o Saldo do Produto
        prod.atualizaSaldo(request.getQuantidade(), request.getTipoMovimento());
        produtoRepository.save(prod);
        return mvtoSalvo;
    }

    public List<MovimentoEstoque> listarHistorico(Integer id) {
        return estoqueRepository.findByProdutoId(id);
    }

}
