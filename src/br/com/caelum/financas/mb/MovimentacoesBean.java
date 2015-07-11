package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.financas.dao.CategoriaDao;
import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;


@Named
@SessionScoped
public class MovimentacoesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContaDao contaDao;
	
	@Inject
	private MovimentacaoDao movimentacaoDao;
	
	@Inject
	private CategoriaDao categoriaDao;
	
	private Categoria categoria = new Categoria();
	
	private Movimentacao movimentacao = new Movimentacao();
	
	private List<Movimentacao> movimentacoes;
	
	private Integer contaId = 1;
	private Integer categoriaId;
	private List<Categoria> categorias;
	
	
	public void grava() {
		Conta contaRelacionada = contaDao.busca(contaId);
		movimentacao.setConta(contaRelacionada);
		
		movimentacaoDao.adiciona(movimentacao);
		this.movimentacoes = movimentacaoDao.lista();
		
		System.out.println("Fazendo a gravacao da movimentacao");
		limpaFormularioDoJSF();
	}
	

	public void remove() {
		Conta contaRelacionada = contaDao.busca(contaId);
		movimentacao.setConta(contaRelacionada);
		
		movimentacaoDao.remove(movimentacao);
		this.movimentacoes = movimentacaoDao.lista();
	
		System.out.println("Removendo a movimentacao");

		
		limpaFormularioDoJSF();
	}

	public List<Movimentacao> getMovimentacoes() {
		Conta contaRelacionada = contaDao.busca(contaId);
		movimentacao.setConta(contaRelacionada);
		
		if(this.movimentacoes == null){
			this.movimentacoes = movimentacaoDao.lista();
		}
	
		return this.movimentacoes;
	}
	
	public Movimentacao getMovimentacao() {
		return movimentacao;
	}
	
	public void adicionaCategoria() {
		if(this.categoriaId != null && this.categoriaId > 0) {
			this.movimentacao.getCategorias().add(categoria);
		}
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}
	

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	
	public ContaDao getContaDao() {
		return contaDao;
	}


	public void setContaDao(ContaDao contaDao) {
		this.contaDao = contaDao;
	}


	public MovimentacaoDao getMovimentacaoDao() {
		return movimentacaoDao;
	}


	public void setMovimentacaoDao(MovimentacaoDao movimentacaoDao) {
		this.movimentacaoDao = movimentacaoDao;
	}


	public CategoriaDao getCategoriaDao() {
		return categoriaDao;
	}


	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}


	public List<Categoria> getCategorias() {
		if(this.categorias == null) {
			System.out.println("Listando as categorias");
		}
		return this.categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	

	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	/**
	 * Esse metodo apenas limpa o formulario da forma com que o JSF espera.
	 * Invoque-o no momento manager que precisar do formulario vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.movimentacao = new Movimentacao();
	}

	public TipoMovimentacao[] getTiposDeMovimentacao() {
		return TipoMovimentacao.values();
	}
	
	
	
	
}
