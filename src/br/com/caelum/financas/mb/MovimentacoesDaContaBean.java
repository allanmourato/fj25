package br.com.caelum.financas.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

@Named
@RequestScoped
public class MovimentacoesDaContaBean {

	@Inject
	private MovimentacaoDao dao;
	
	private List<Movimentacao> movimentacoes;
	private Conta conta = new Conta();
	
	public List<Movimentacao> lista()  {
		dao.listaTodasMovimentacoes(conta);
		return movimentacoes;
	}
	
	public void adiciona(Movimentacao movimentacao) {
		dao.adiciona(movimentacao);
		System.out.println("Movimentação Adicionada com sucesso");
		
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
