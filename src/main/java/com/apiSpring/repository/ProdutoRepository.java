package com.apiSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiSpring.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	Produto findById(long idProduto);
}
