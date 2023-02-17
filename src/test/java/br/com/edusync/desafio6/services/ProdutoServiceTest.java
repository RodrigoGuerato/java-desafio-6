package br.com.edusync.desafio6.services;

import br.com.edusync.desafio6.models.Produto;
import br.com.edusync.desafio6.repositories.ProdutoRepository;
import br.com.edusync.desafio6.repositories.ProdutoRepositoryCustom;
import br.com.edusync.desafio6.repositories.params.FiltroProdutoParam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ProdutoRepositoryCustom produtoRepositoryCustom;

    @Test
    public void testFiltroCriteria() {
        FiltroProdutoParam params = new FiltroProdutoParam();
        List<Produto> listaFake = createMockList();
        Mockito.when(produtoRepositoryCustom.getFiltro(params)).thenReturn(listaFake);

        List<Produto> listaProd = produtoService.filtrar(params);

        Assertions.assertEquals(1, listaProd.size());
    }

    @Test
    public void testProdutosComSaldoPositivo() {
        List<Produto> listaFake = createMockList();
        Mockito.when(produtoRepository.findAll()).thenReturn(listaFake);

        int quantidadeRegistros = produtoService.getProdutoComSaldo().size();

        Assertions.assertEquals(1, quantidadeRegistros);
    }
    @Test
    public void testSalvarProduto() {
        Produto produtoRetorno = new Produto();
        produtoRetorno.setId(1);
        produtoRetorno.setDescricao("Testes de Salvar");
        Mockito.when(produtoRepository.save(produtoRetorno)).thenReturn(produtoRetorno);

        Produto prod = produtoService.salvar(produtoRetorno);

        Assertions.assertEquals(produtoRetorno.getId(), prod.getId());
    }

    @Test
    public void testGetById() {
        Produto produtoRetorno = new Produto();
        produtoRetorno.setId(1);
        produtoRetorno.setDescricao("Testes de Salvar");
        Optional<Produto> optionalProduto = Optional.of(produtoRetorno);
        Mockito.when(produtoRepository.findById(1)).thenReturn(optionalProduto);

        Produto prod = produtoService.getById(1);

        Assertions.assertEquals(produtoRetorno.getId(), prod.getId());
    }

    private List<Produto> createMockList() {
        List<Produto> lista = new ArrayList<>();
        Produto prod = new Produto();
        prod.setDescricao("Produto de testes");
        prod.atualizaSaldo(10, "E");
        lista.add(prod);
        return lista;
    }


}
