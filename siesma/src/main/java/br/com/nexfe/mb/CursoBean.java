package br.com.nexfe.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.nexfe.constantes.ConstantesExclusao;
import br.com.nexfe.dao.CursoDAO;
import br.com.nexfe.dao.TurnoDAO;
import br.com.nexfe.entidades.Curso;
import br.com.nexfe.entidades.Turno;

@ManagedBean
@ViewScoped
public class CursoBean {
	
	private CursoDAO cursoDAO;
	
	private TurnoDAO turnoDAO;
	
	private Curso curso;
	
	private Curso cursoExclusao;
	
	private List<Curso> cursos;
	
	private List<Curso> cursosFiltrados;
	
	private List<Turno> turnos;
	
	public void init() {
		cursoDAO = new CursoDAO();
		turnoDAO = new TurnoDAO();
		setCursos(cursoDAO.listarTodosSemDistincao());
		setTurnos(turnoDAO.listar(Turno.class));
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
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Alterado com sucesso!"));
			}
		} else {
			getCurso().setInExcluido(ConstantesExclusao.NAO_EXCLUIDO.getNome());
			cursoDAO.salvar(getCurso());	
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Incluido com sucesso!"));
		}
		init();
	}
	
	public void selectDelete(Curso c){
		setCursoExclusao(c);
	}
	   
	public void delete(){
		getCursoExclusao().setInExcluido(ConstantesExclusao.EXCLUIDO.getNome());
		cursoDAO.alterar(getCursoExclusao());
		setCursoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Excluido com sucesso!"));
		init();
	}
	
	public void reativar(){
		getCursoExclusao().setInExcluido(ConstantesExclusao.NAO_EXCLUIDO.getNome());
		cursoDAO.alterar(getCursoExclusao());
		setCursoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Reativado com sucesso!"));
		init();
	}
	
	///////////////////////// VALIDATORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	public void validateNomeCurso(FacesContext fc, UIComponent uic, Object obj) throws ValidatorException {
		String nome = (String) obj;
		for(Curso c : getCursos()) {
			if(c.getNome().equalsIgnoreCase(nome)) {
				if(getCurso().getIdCurso() != null && getCurso().getIdCurso() == c.getIdCurso()) {
					System.out.println("Trouxe o mesmo nome do curso sendo alterado");
				} else {
					FacesMessage msg = new FacesMessage("Curso já existente!");
					msg.setSeverity(FacesMessage.SEVERITY_ERROR);
					throw new ValidatorException(msg);
				}
			}
		}
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

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	
}
