package com.eduardo.crud.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.eduardo.crud.entity.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id", "nome", "estoque", "preco"})
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProdutoVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("name")
	private Integer estoque;
	
	@JsonProperty("preco")
	private Double preco;
	
	public static ProdutoVO create(Produto produto) {
		return new ModelMapper().map(produto, ProdutoVO.class);
	}

}
