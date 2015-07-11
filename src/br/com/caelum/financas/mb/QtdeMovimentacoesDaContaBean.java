package br.com.caelum.financas.mb;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class QtdeMovimentacoesDaContaBean {
	
	@Inject
	private ContaDao dao;
	
	private Conta conta = new Conta();
	private int quantidade;
	
	public void lista() {
		conta = dao.busca(conta.getId());
		quantidade = conta.getMovimentacoes().size();
		System.out.println("Exibindo as quantidades de movimentacoes da conta");

	
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
