package br.com.nexfe.mb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import br.com.nexfe.dao.AvaliacaoDAO;
import br.com.nexfe.entidades.Avaliacao;
import br.com.nexfe.entidades.AvaliacaoNota;
import br.com.nexfe.entidades.Matricula;

@ManagedBean(name = "avaliacaoNotaBean")
@ViewScoped
public class AvaliacaoNotaBean {
	
	private AvaliacaoDAO avaliacaoDAO;
	
	private Avaliacao avaliacao;
	
	private Avaliacao avaliacaoExclusao;
	
	private List<Avaliacao> avaliacoes;
	
	private List<Avaliacao> avaliacoesComNotas;
	
	private List<Matricula> matriculas;
	
	private List<Avaliacao> avaliacoesFiltradas;
	
	private Boolean operacaoInclusao;
	
	public void init() {
		avaliacaoDAO = new AvaliacaoDAO();
		setAvaliacoes(avaliacaoDAO.listarDataAtual());
		setAvaliacoesComNotas(avaliacaoDAO.listarAvaliacoesComNota());
		setAvaliacao(null);
	}

	public void back() {
		setAvaliacao(null);
	}

	public void add() {
		setOperacaoInclusao(Boolean.TRUE);
		setAvaliacao(new Avaliacao());
	}
	
	public void edit(Avaliacao a){
		setOperacaoInclusao(Boolean.FALSE);
		setAvaliacao(a);
	}
	
	public void saveAndUpdate() {
		avaliacaoDAO.alterar(getAvaliacao());
		if(getOperacaoInclusao()) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Incluido com sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Alterado com sucesso!"));
		}
		init();
	}
	
	public void selectDelete(Avaliacao p){
		setAvaliacaoExclusao(p);
	}
	   
	public void delete(){
		getAvaliacaoExclusao().getAvaliacoesNotas().clear();
		avaliacaoDAO.alterar(getAvaliacaoExclusao());
		setAvaliacaoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Excluido com sucesso!"));
		init();
	}
	
	public List<Avaliacao> autoCompleteAvaliacao(String query) {
		List<Avaliacao> sugestoes = new ArrayList<Avaliacao>();
		for (Avaliacao a : getAvaliacoes()) {
			if (a.getNome().toUpperCase().startsWith(query.toUpperCase())) {
				sugestoes.add(a);
			}
		}
		return sugestoes;
	}
	
	////////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public void carregaAlunosAvaliacoes(ValueChangeEvent e) {
		setAvaliacao((Avaliacao) e.getNewValue());
		AvaliacaoNota avaliacaoNota = null;
		this.getAvaliacao().getAvaliacoesNotas().clear();
		for(Matricula matricula : getAvaliacao().getDisciplina().getModulo().getMatriculas()) {
			avaliacaoNota = new AvaliacaoNota();
			avaliacaoNota.setMatricula(matricula);
			avaliacaoNota.setAvaliacao(this.getAvaliacao());
			avaliacaoNota.setNota(BigDecimal.ZERO);
			this.getAvaliacao().getAvaliacoesNotas().add(avaliacaoNota);
		}
	}
	
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Avaliacao getAvaliacaoExclusao() {
		return avaliacaoExclusao;
	}

	public void setAvaliacaoExclusao(Avaliacao avaliacaoExclusao) {
		this.avaliacaoExclusao = avaliacaoExclusao;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	public List<Avaliacao> getAvaliacoesComNotas() {
		return avaliacoesComNotas;
	}

	public void setAvaliacoesComNotas(List<Avaliacao> avaliacoesComNotas) {
		this.avaliacoesComNotas = avaliacoesComNotas;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Avaliacao> getAvaliacoesFiltradas() {
		return avaliacoesFiltradas;
	}

	public void setAvaliacoesFiltradas(List<Avaliacao> avaliacoesFiltradas) {
		this.avaliacoesFiltradas = avaliacoesFiltradas;
	}

	public Boolean getOperacaoInclusao() {
		return operacaoInclusao;
	}

	public void setOperacaoInclusao(Boolean operacaoInclusao) {
		this.operacaoInclusao = operacaoInclusao;
	}
	
}
