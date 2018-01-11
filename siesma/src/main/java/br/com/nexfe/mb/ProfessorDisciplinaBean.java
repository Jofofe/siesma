package br.com.nexfe.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.dao.DisciplinaDAO;
import br.com.nexfe.dao.EmpregadoDAO;
import br.com.nexfe.dao.ProfessorDisciplinaDAO;
import br.com.nexfe.entidades.Disciplina;
import br.com.nexfe.entidades.Empregado;
import br.com.nexfe.entidades.ProfessorDisciplina;

@ManagedBean
@ViewScoped
public class ProfessorDisciplinaBean {
	
	private ProfessorDisciplinaDAO profDiscDAO;
	
	private DisciplinaDAO disciplinaDAO;
	
	private EmpregadoDAO empregadoDAO;
	
	private ProfessorDisciplina professorDisciplina;
	
	private ProfessorDisciplina professorDisciplinaExclusao;
	
	private List<ProfessorDisciplina> professoresDisciplinasFiltrados;
	
	private List<Empregado> empregados;
	
	private List<Disciplina> disciplinas;
	
	private List<ProfessorDisciplina> professoresDisciplinas;
	
	public void init() {
		profDiscDAO = new ProfessorDisciplinaDAO();
		disciplinaDAO = new DisciplinaDAO();
		empregadoDAO = new EmpregadoDAO();
		setProfessoresDisciplinas(profDiscDAO.listarDataAtual());
		setDisciplinas(disciplinaDAO.listarDataAtual());
		setEmpregados(empregadoDAO.listarProfessores());
		setProfessorDisciplina(null);
	}

	public void back() {
		setProfessorDisciplina(null);
	}

	public void add() {
		setProfessorDisciplina(new ProfessorDisciplina());
	}
	
	public void edit(ProfessorDisciplina d){
		setProfessorDisciplina(d);
	}
	
	public void saveAndUpdate() {
		if (getProfessorDisciplina().getIdProfessorDisciplina() != null) {
			if (getProfessorDisciplina().getIdProfessorDisciplina() > 0) {
				profDiscDAO.alterar(getProfessorDisciplina());			
			}
		} else {
			profDiscDAO.salvar(getProfessorDisciplina());		
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Operação realizada com sucesso!"));
		init();
	}
	
	public void selectDelete(ProfessorDisciplina d){
		setProfessorDisciplinaExclusao(d);
	}
	
	//public boolean canDelete(ProfessorDisciplina d) {
	//	return d.get() == null || d.get().isEmpty();
	//}
	   
	public void delete(){
		profDiscDAO.excluir(getProfessorDisciplinaExclusao());
		setProfessorDisciplinaExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Exclusão realizada com sucesso!"));
		init();
	}
	
	////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\

	public ProfessorDisciplina getProfessorDisciplina() {
		return professorDisciplina;
	}

	public void setProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
		this.professorDisciplina = professorDisciplina;
	}

	public ProfessorDisciplina getProfessorDisciplinaExclusao() {
		return professorDisciplinaExclusao;
	}

	public void setProfessorDisciplinaExclusao(ProfessorDisciplina professorDisciplinaExclusao) {
		this.professorDisciplinaExclusao = professorDisciplinaExclusao;
	}

	public List<ProfessorDisciplina> getProfessoresDisciplinas() {
		return professoresDisciplinas;
	}

	public void setProfessoresDisciplinas(List<ProfessorDisciplina> professoresDisciplinas) {
		this.professoresDisciplinas = professoresDisciplinas;
	}
	
	public List<ProfessorDisciplina> getProfessoresDisciplinasFiltrados() {
		return professoresDisciplinasFiltrados;
	}

	public void setProfessoresDisciplinasFiltrados(List<ProfessorDisciplina> professoresDisciplinasFiltrados) {
		this.professoresDisciplinasFiltrados = professoresDisciplinasFiltrados;
	}

	public List<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
}