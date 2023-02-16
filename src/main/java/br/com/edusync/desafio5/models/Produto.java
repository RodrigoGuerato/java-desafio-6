package br.com.edusync.desafio5.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private BigDecimal precoUnitario;
    private Integer saldoAtual;

    public void atualizaSaldo(Integer quantidade, String tipoMovimento) {
        if (tipoMovimento.equals("E")) {
            this.saldoAtual += quantidade;
        } else {
            this.saldoAtual -= quantidade;
        }
    }
}
