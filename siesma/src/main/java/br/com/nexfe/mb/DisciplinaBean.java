package br.com.nexfe.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.dao.DisciplinaDAO;
import br.com.nexfe.dao.ModuloDAO;
import br.com.nexfe.entidades.Disciplina;
import br.com.nexfe.entidades.Modulo;

@ManagedBean
@ViewScoped
public class DisciplinaBean {
	
	private DisciplinaDAO disciplinaDAO;
	
	private ModuloDAO moduloDAO;
	
	private Disciplina disciplina;
	
	private Disciplina disciplinaExclusao;
	
	private List<Modulo> modulos;
	
	private List<Disciplina> disciplinas;
	
	private List<Disciplina> disciplinasFiltrados;
	
	public void init() {
		disciplinaDAO = new DisciplinaDAO();
		moduloDAO = new ModuloDAO();
		setModulos(moduloDAO.listarDataAtual());
		setDisciplinas(disciplinaDAO.listarDataAtual());
		setDisciplina(null);
	}

	public void back() {
		setDisciplina(null);
	}

	public void add() {
		setDisciplina(new Disciplina());
	}
	
	public void edit(Disciplina d){
		setDisciplina(d);
	}
	
	public void saveAndUpdate() {
		if (getDisciplina().getIdDisciplina() != null) {
			if (getDisciplina().getIdDisciplina() > 0) {
				disciplinaDAO.alterar(getDisciplina());			
			}
		} else {
			disciplinaDAO.salvar(getDisciplina());		
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Operação realizada com sucesso!"));
		init();
	}
	
	public void selectDelete(Disciplina d){
		setDisciplinaExclusao(d);
	}
	
	public boolean canDelete(Disciplina d) {
		return (d.getAvaliacoes() == null || d.getAvaliacoes().isEmpty()) && 
				(d.getProfessoresDisciplinas() == null || d.getProfessoresDisciplinas().isEmpty());
	}
	   
	public void delete(){
		disciplinaDAO.excluir(getDisciplinaExclusao());
		setDisciplinaExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Exclusão realizada com sucesso!"));
		init();
	}
	
	////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Disciplina getDisciplinaExclusao() {
		return disciplinaExclusao;
	}

	public void setDisciplinaExclusao(Disciplina disciplinaExclusao) {
		this.disciplinaExclusao = disciplinaExclusao;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Disciplina> getDisciplinasFiltrados() {
		return disciplinasFiltrados;
	}

	public void setDisciplinasFiltrados(List<Disciplina> disciplinasFiltrados) {
		this.disciplinasFiltrados = disciplinasFiltrados;
	}
	
}
