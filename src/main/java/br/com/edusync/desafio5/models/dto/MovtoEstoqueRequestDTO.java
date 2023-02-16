package br.com.edusync.desafio5.models.dto;

import br.com.edusync.desafio5.models.MovimentoEstoque;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovtoEstoqueRequestDTO {

    private Integer produtoId;
    private Integer quantidade;
    private String tipoMovimento;

}
