package com.eduardo.pagamento.entity.data.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.eduardo.pagamento.entity.ProdutoVenda;
import com.eduardo.pagamento.entity.Venda;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","data","produtos","valorTotal"})
public class VendaVO extends RepresentationModel<VendaVO> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public VendaVO() {
		
	}
	
	public VendaVO(Long id, Date data, List<ProdutoVenda> produtos, Double valorTotal) {
		super();
		this.id = id;
		this.data = data;
		this.produtos = produtos;
		this.valorTotal = valorTotal;
	}

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("data")
	private Date data;
	
	@JsonProperty("produtos")
	private List<ProdutoVenda> produtos;
	
	@JsonProperty("valorTotal")
	private Double valorTotal;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<ProdutoVenda> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoVenda> produtos) {
		this.produtos = produtos;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public static VendaVO create(Venda venda) {
		return new ModelMapper().map(venda, VendaVO.class);
	}
	
	
	@Override
	public String toString() {
		return "VendaVO [id=" + id + ", data=" + data + ", produtos=" + produtos + ", valorTotal=" + valorTotal + "]";
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
		VendaVO other = (VendaVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
