package br.com.edusync.desafio6.services;

import br.com.edusync.desafio6.models.MovimentoEstoque;
import br.com.edusync.desafio6.models.Produto;
import br.com.edusync.desafio6.models.dto.MovtoEstoqueRequestDTO;
import br.com.edusync.desafio6.repositories.MovimentoEstoqueRepository;
import br.com.edusync.desafio6.repositories.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class EstoqueServiceTest {

    @InjectMocks
    private EstoqueService estoqueService;

    @Mock
    private MovimentoEstoqueRepository movimentoEstoqueRepository;

    @Mock
    private ProdutoRepository produtoRepository;


    @Test
    public void testListarHistorico() {
        Mockito.when(movimentoEstoqueRepository.findByProdutoId(1)).thenReturn(createFakeList());
        List<MovimentoEstoque> listaEstoque = estoqueService.listarHistorico(1);
        Assertions.assertEquals(1, listaEstoque.size());
    }

    @Test
    public void testMovimentarEstoque() {
        Produto produto = new Produto();
        produto.setId(10);
        produto.setDescricao("Testes");
        Mockito.when(produtoRepository.findById(10)).thenReturn(Optional.of(produto));

        MovimentoEstoque retornoFake = new MovimentoEstoque();
        retornoFake.setProduto(produto);
        retornoFake.setQuantidade(1);
        Mockito.when(movimentoEstoqueRepository.save(retornoFake)).thenReturn(retornoFake);

        MovtoEstoqueRequestDTO movtoEstoqueRequestDTO = new MovtoEstoqueRequestDTO();
        movtoEstoqueRequestDTO.setProdutoId(10);
        movtoEstoqueRequestDTO.setTipoMovimento("S");
        movtoEstoqueRequestDTO.setQuantidade(1);
        MovimentoEstoque retorno = estoqueService.movimentarEstoque(movtoEstoqueRequestDTO);

        Assertions.assertEquals(retorno.getId(), retornoFake.getId());
    }

    private List<MovimentoEstoque> createFakeList() {
        List<MovimentoEstoque> listaMovimento = new ArrayList<>();
        MovimentoEstoque mvto = new MovimentoEstoque();
        mvto.setProduto(new Produto());
        listaMovimento.add(mvto);
        return listaMovimento;
    }

}
