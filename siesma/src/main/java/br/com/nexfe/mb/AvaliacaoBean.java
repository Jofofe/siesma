package br.com.nexfe.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.dao.AvaliacaoDAO;
import br.com.nexfe.dao.DisciplinaDAO;
import br.com.nexfe.dao.TipoAvaliacaoDAO;
import br.com.nexfe.entidades.Avaliacao;
import br.com.nexfe.entidades.Disciplina;
import br.com.nexfe.entidades.TipoAvaliacao;

@ManagedBean
@ViewScoped
public class AvaliacaoBean {
	
	private AvaliacaoDAO avaliacaoDAO;
	
	private TipoAvaliacaoDAO tipoAvaliacaoDAO;
	
	private DisciplinaDAO disciplinaDAO;
	
	private Avaliacao avaliacao;
	
	private Avaliacao avaliacaoExclusao;
	
	private List<Avaliacao> avaliacoes;
	
	private List<TipoAvaliacao> tiposAvaliacoes;
	
	private List<Disciplina> disciplinas;
	
	private List<Avaliacao> avaliacaoFiltrados;
	
	public void init() {
		avaliacaoDAO = new AvaliacaoDAO();
		tipoAvaliacaoDAO = new TipoAvaliacaoDAO();
		disciplinaDAO = new DisciplinaDAO();
		setAvaliacoes(avaliacaoDAO.listarDataAtual());
		setTiposAvaliacoes(tipoAvaliacaoDAO.listar(TipoAvaliacao.class));
		setDisciplinas(disciplinaDAO.listarDataAtual());
		setAvaliacao(null);
	}

	public void back() {
		setAvaliacao(null);
	}

	public void add() {
		setAvaliacao(new Avaliacao());
	}
	
	public void edit(Avaliacao a){
		setAvaliacao(a);
	}
	
	public void saveAndUpdate() {
		if (getAvaliacao().getIdAvaliacao()!= null) {
			if (getAvaliacao().getIdAvaliacao() > 0) {
				avaliacaoDAO.alterar(getAvaliacao());			
			}
		} else {
			avaliacaoDAO.salvar(getAvaliacao());		
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Operação realizada com sucesso!"));
		init();
	}
	
	//public boolean canDelete(Avaliacao a) {
	//	return a.get() == null || a.get.isEmpty();
	//}
	
	public void selectDelete(Avaliacao a){
		setAvaliacaoExclusao(a);
	}
	   
	public void delete(){
		avaliacaoDAO.excluir(getAvaliacaoExclusao());
		setAvaliacaoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Exclusão realizada com sucesso!"));
		init();
	}
	
	////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\

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

	public List<TipoAvaliacao> getTiposAvaliacoes() {
		return tiposAvaliacoes;
	}

	public void setTiposAvaliacoes(List<TipoAvaliacao> tiposAvaliacoes) {
		this.tiposAvaliacoes = tiposAvaliacoes;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Avaliacao> getAvaliacaoFiltrados() {
		return avaliacaoFiltrados;
	}

	public void setAvaliacaoFiltrados(List<Avaliacao> avaliacaoFiltrados) {
		this.avaliacaoFiltrados = avaliacaoFiltrados;
	}
	
}
