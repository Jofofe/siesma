package br.com.nexfe.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.dao.CursoDAO;
import br.com.nexfe.dao.ModuloDAO;
import br.com.nexfe.entidades.Curso;
import br.com.nexfe.entidades.Modulo;

@ManagedBean
@ViewScoped
public class ModuloBean {
	
	private ModuloDAO moduloDAO;
	
	private CursoDAO cursoDAO;
	
	private Modulo modulo;
	
	private Modulo moduloExclusao;
	
	private List<Curso> cursos;
	
	private List<Modulo> modulos;
	
	private List<Modulo> modulosFiltrados;
	
	public void init() {
		moduloDAO = new ModuloDAO();
		cursoDAO = new CursoDAO();
		setCursos(cursoDAO.listar(Curso.class));
		setModulos(moduloDAO.listar(Modulo.class));
		setModulo(null);
	}

	public void back() {
		setModulo(null);
	}

	public void add() {
		setModulo(new Modulo());
	}
	
	public void edit(Modulo m){
		setModulo(m);
	}
	
	public void saveAndUpdate() {
		if (getModulo().getIdModulo() != null) {
			if (getModulo().getIdModulo() > 0) {
				moduloDAO.alterar(getModulo());			
			}
		} else {
			moduloDAO.salvar(getModulo());		
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Operação realizada com sucesso!"));
		init();
	}
	
	public void selectDelete(Modulo m){
		setModuloExclusao(m);
	}
	   
	public void delete(){
		moduloDAO.excluir(getModuloExclusao());
		setModuloExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Exclusão realizada com sucesso!"));
		init();
	}
	
	////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\

	public List<Curso> getCursos() {
		return cursos;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Modulo getModuloExclusao() {
		return moduloExclusao;
	}

	public void setModuloExclusao(Modulo moduloExclusao) {
		this.moduloExclusao = moduloExclusao;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public List<Modulo> getModulosFiltrados() {
		return modulosFiltrados;
	}

	public void setModulosFiltrados(List<Modulo> modulosFiltrados) {
		this.modulosFiltrados = modulosFiltrados;
	}
	
}
