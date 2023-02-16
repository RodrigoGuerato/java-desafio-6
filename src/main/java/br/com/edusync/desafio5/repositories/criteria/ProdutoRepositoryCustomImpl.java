package br.com.edusync.desafio5.repositories.criteria;

import br.com.edusync.desafio5.models.Produto;
import br.com.edusync.desafio5.repositories.ProdutoRepositoryCustom;
import br.com.edusync.desafio5.repositories.params.FiltroProdutoParam;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepositoryCustomImpl implements ProdutoRepositoryCustom {

    private EntityManager entityManager;

    public ProdutoRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Produto> getFiltro(FiltroProdutoParam params) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = criteriaBuilder.createQuery(Produto.class);

        Root<Produto> produto = query.from(Produto.class);
        List<Predicate> predicates = new ArrayList<>();

        if ( params.getDescricao() != null ) {
            predicates.add(criteriaBuilder.like(produto.get("descricao"), "%" + params.getDescricao() + "%"));
        }
        if ( params.getSaldoAtual() != null ) {
            predicates.add(criteriaBuilder.equal(produto.get("saldoAtual"), params.getSaldoAtual()));
        }

        TypedQuery<Produto> queryResult = this.entityManager.createQuery(query);
        return queryResult.getResultList();
    }
}
