package br.com.edusync.desafio6.models.dto;

import lombok.Data;

@Data
public class MovtoEstoqueRequestDTO {

    private Integer produtoId;
    private Integer quantidade;
    private String tipoMovimento;

}
