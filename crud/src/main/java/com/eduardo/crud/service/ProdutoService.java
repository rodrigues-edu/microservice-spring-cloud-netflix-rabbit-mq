package com.eduardo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.crud.data.vo.ProdutoVO;
import com.eduardo.crud.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository repository;
	
	@Autowired
	public ProdutoService(ProdutoRepository repository) {
		this.repository = repository;
	}
	
	
	public ProdutoVO create(ProdutoVO produtoVO) {
		return null;
	}

}
