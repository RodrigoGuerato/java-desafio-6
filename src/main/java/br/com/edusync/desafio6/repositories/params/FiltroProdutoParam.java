package br.com.edusync.desafio6.repositories.params;

import lombok.Data;

@Data
public class FiltroProdutoParam {
    private String descricao;
    private Integer saldoAtual;
}
