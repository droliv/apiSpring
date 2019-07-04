package com.apiSpring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiSpring.models.Produto;
import com.apiSpring.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produto")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	@GetMapping("/produto/{idProduto}")
	public Produto mostraProduto(@PathVariable(value="idProduto") long idProduto){
		return produtoRepository.findById(idProduto);
	}
	@PostMapping("/produto")
	public Produto cadastrarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	@PutMapping("/produto/{idProduto}")
	public Produto alterarProduto(@PathVariable(value="idProduto") long idProduto, @RequestBody Produto produtoalter) {
		Produto produto = produtoRepository.findById(idProduto);
		produto.setNomeProduto(produtoalter.getNomeProduto());
		produto.setQuantidade(produtoalter.getQuantidade());
		produto.setValor(produtoalter.getValor());
		return produtoRepository.save(produto);
	}
	@DeleteMapping("/produto/{idProduto}")
	public String deletarProduto(@PathVariable(value="idProduto") long idProduto) {
		 produtoRepository.deleteById(idProduto);
		 return "Produto Deletado";

	}
}
