package br.com.nexfe.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.dao.AlunoDAO;
import br.com.nexfe.dao.CursoDAO;
import br.com.nexfe.dao.MatriculaDAO;
import br.com.nexfe.entidades.Aluno;
import br.com.nexfe.entidades.Curso;
import br.com.nexfe.entidades.Matricula;

@ManagedBean(name = "matriculaBean")
@ViewScoped
public class MatriculaBean {
	
	private MatriculaDAO matriculaDAO;
	
	private AlunoDAO alunoDAO;
	
	private CursoDAO cursoDAO;
	
	private Matricula matricula;
	
	private Matricula matriculaExclusao;
	
	private List<Matricula> matriculas;
	
	private List<Aluno> alunos;
	
	private List<Curso> cursos;
	
	private List<Matricula> matriculasFiltradas;
	
	public void init() {
		matriculaDAO = new MatriculaDAO();
		alunoDAO = new AlunoDAO();
		cursoDAO = new CursoDAO();
		setMatriculas(matriculaDAO.listar(Matricula.class));
		setAlunos(alunoDAO.listar(Aluno.class));
		setCursos(cursoDAO.listar(Curso.class));
		setMatricula(null);
	}

	public void back() {
		setMatricula(null);
	}

	public void add() {
		setMatricula(new Matricula());
	}
	
	public void edit(Matricula m){
		setMatricula(m);
	}
	
	public void saveAndUpdate() {
		if (getMatricula().getIdMatricula() != null) {
			if (getMatricula().getIdMatricula() > 0) {
				matriculaDAO.alterar(getMatricula());			
			}
		} else {
			matriculaDAO.salvar(getMatricula());		
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Operação realizada com sucesso!"));
		init();
	}
	
	public void selectDelete(Matricula m){
		setMatriculaExclusao(m);
	}
	   
	public void delete(){
		matriculaDAO.excluir(getMatriculaExclusao());
		setMatriculaExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Exclusão realizada com sucesso!"));
		init();
	}
	
	////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\

	public CursoDAO getCursoDAO() {
		return cursoDAO;
	}

	public void setCursoDAO(CursoDAO cursoDAO) {
		this.cursoDAO = cursoDAO;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Matricula getMatriculaExclusao() {
		return matriculaExclusao;
	}

	public void setMatriculaExclusao(Matricula matriculaExclusao) {
		this.matriculaExclusao = matriculaExclusao;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Matricula> getMatriculasFiltradas() {
		return matriculasFiltradas;
	}

	public void setMatriculasFiltradas(List<Matricula> matriculasFiltradas) {
		this.matriculasFiltradas = matriculasFiltradas;
	}
	
}
