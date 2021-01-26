package com.eduardo.crud.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.eduardo.crud.entity.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({"id","nome","estoque","preco"})
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode//(callSuper = false)
public class ProdutoVO implements Serializable {

	private static final long serialVersionUID = 2938272643682548375L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("estoque")
	private Integer estoque;
	
	@JsonProperty("preco")
	private Double preco;
	
	public static ProdutoVO create(Produto produto) {
		return new ModelMapper().map(produto, ProdutoVO.class);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
