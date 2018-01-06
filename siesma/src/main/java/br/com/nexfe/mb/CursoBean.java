package br.com.nexfe.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.dao.CursoDAO;
import br.com.nexfe.entidades.Curso;

@ManagedBean
@ViewScoped
public class CursoBean {
	
	private CursoDAO cursoDAO;
	
	private Curso curso;
	
	private Curso cursoExclusao;
	
	private List<Curso> cursos;
	
	private List<Curso> cursosFiltrados;
	
	public void init() {
		cursoDAO = new CursoDAO();
		setCursos(cursoDAO.listar(Curso.class));
		setCurso(null);
	}

	public void back() {
		setCurso(null);
	}

	public void add() {
		setCurso(new Curso());
	}
	
	public void edit(Curso c){
		setCurso(c);
	}
	
	public void saveAndUpdate() {
		if (getCurso().getIdCurso() != null) {
			if (getCurso().getIdCurso() > 0) {
				cursoDAO.alterar(getCurso());			
			}
		} else {
			cursoDAO.salvar(getCurso());		
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Operação realizada com sucesso!"));
		init();
	}
	
	public void selectDelete(Curso c){
		setCursoExclusao(c);
	}
	   
	public void delete(){
		cursoDAO.excluir(getCursoExclusao());
		setCursoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Exclusão realizada com sucesso!"));
		init();
	}
	
	////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Curso getCursoExclusao() {
		return cursoExclusao;
	}

	public void setCursoExclusao(Curso cursoExclusao) {
		this.cursoExclusao = cursoExclusao;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Curso> getCursosFiltrados() {
		return cursosFiltrados;
	}

	public void setCursosFiltrados(List<Curso> cursosFiltrados) {
		this.cursosFiltrados = cursosFiltrados;
	}
	
}
