package com.eduardo.pagamento.entity.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.eduardo.pagamento.entity.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","data","produtos","valorTotal"})
public class ProdutoVO extends RepresentationModel<ProdutoVO> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public ProdutoVO() {
		
	}
	
	public ProdutoVO(Long id, Integer estoque) {
		super();
		this.id = id;
		this.estoque = estoque;
	}

	@JsonProperty("id")
	private Long id;
	
	
	@JsonProperty("estoque")
	private Integer estoque;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	
	
	public static ProdutoVO create(Produto produto) {
		return new ModelMapper().map(produto, ProdutoVO.class);
	}
	

	@Override
	public String toString() {
		return "ProdutoVO [id=" + id + ", estoque=" + estoque + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoVO other = (ProdutoVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
