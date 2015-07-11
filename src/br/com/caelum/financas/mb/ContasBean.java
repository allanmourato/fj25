package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;

@Named
@SessionScoped
public class ContasBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ContaDao contaDao;

	private Conta conta = new Conta();
	private List<Conta> contas;

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void grava() {
		
		contaDao.adiciona(conta);
		this.contas = contaDao.lista();
		System.out.println("Gravando a conta");

		limpaFormularioDoJSF();
	}

	public List<Conta> getContas() {
		if(this.contas == null) {
			this.contas = contaDao.lista();
		}
		System.out.println("Listando as contas");

		return this.contas;
	}

	public void remove() {
		contaDao.remove(conta);
		this.contas = contaDao.lista();
		System.out.println("Removendo a conta");

		limpaFormularioDoJSF();
	}

	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento em que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.conta = new Conta();
	}
}
