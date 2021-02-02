package com.eduardo.pagamento.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.eduardo.pagamento.entity.Produto;
import com.eduardo.pagamento.entity.data.vo.ProdutoVO;
import com.eduardo.pagamento.repository.ProdutoReposytory;

@Component
public class ProdutoReceiveMessage {
	
	private final ProdutoReposytory reposytory;

	@Autowired
	public ProdutoReceiveMessage(ProdutoReposytory reposytory) {
		this.reposytory = reposytory;
	}
	
	@RabbitListener(queues = {"${crud.rabbitmq.queue}"}) //Anotação para escutar a fila
	public void receive(@Payload ProdutoVO produtoVO) {
		reposytory.save(Produto.create(produtoVO));
	}
}
