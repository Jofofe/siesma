package br.com.nexfe.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.dao.AlunoDAO;
import br.com.nexfe.dao.CursoDAO;
import br.com.nexfe.dao.DocumentoDAO;
import br.com.nexfe.dao.MatriculaDAO;
import br.com.nexfe.dao.ModuloDAO;
import br.com.nexfe.entidades.Aluno;
import br.com.nexfe.entidades.Curso;
import br.com.nexfe.entidades.Documento;
import br.com.nexfe.entidades.Matricula;
import br.com.nexfe.entidades.MatriculaDocumento;
import br.com.nexfe.entidades.Modulo;

@ManagedBean(name = "matriculaBean")
@ViewScoped
public class MatriculaBean {
	
	private MatriculaDAO matriculaDAO;
	
	private AlunoDAO alunoDAO;
	
	private CursoDAO cursoDAO;
	
	private ModuloDAO moduloDAO;
	
	private DocumentoDAO documentoDAO;
	
	private Matricula matricula;
	
	private Matricula matriculaExclusao;
	
	private List<Matricula> matriculas;
	
	private List<Aluno> alunos;
	
	private List<Curso> cursos;
	
	private List<Modulo> modulos;
	
	private List<Matricula> matriculasFiltradas;
	
	public void init() {
		matriculaDAO = new MatriculaDAO();
		alunoDAO = new AlunoDAO();
		cursoDAO = new CursoDAO();
		moduloDAO = new ModuloDAO();
		documentoDAO = new DocumentoDAO();
		setMatriculas(matriculaDAO.listarTodosSemDistincao());
		setAlunos(alunoDAO.listar(Aluno.class));
		setCursos(cursoDAO.listar(Curso.class));
		setModulos(moduloDAO.listarDataAtual());
		setMatricula(null);
	}

	public void back() {
		setMatricula(null);
	}

	public void add() {
		setMatricula(new Matricula());
		carregaMatriculasDocumentos();
	}
	
	public void edit(Matricula m){
		setMatricula(m);
	}
	
	public void saveAndUpdate() {
		if(validaCursosAluno()) {
			if (getMatricula().getIdMatricula() != null) {
				if (getMatricula().getIdMatricula() > 0) {
					matriculaDAO.alterar(getMatricula());
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Alterado com sucesso!"));
				}
			} else {
				matriculaDAO.salvar(getMatricula());
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Incluido com sucesso!"));
			}
			init();
		}
	}
	
	public void selectDelete(Matricula m){
		setMatriculaExclusao(m);
	}
	   
	public void delete(){
		getMatriculaExclusao().setDtCancelamento(new Date());
		matriculaDAO.alterar(getMatriculaExclusao());
		setMatriculaExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Excluido com sucesso!"));
		init();
	}
	
	public void reativar(){
		getMatriculaExclusao().setDtCancelamento(null);
		matriculaDAO.alterar(getMatriculaExclusao());
		setMatriculaExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Reativado com sucesso!"));
		init();
	}
	
	public List<Curso> autoCompleteCurso(String query) {
		List<Curso> sugestoes = new ArrayList<Curso>();
		for (Curso c : getCursos()) {
			if (c.getNome().toUpperCase().startsWith(query.toUpperCase())) {
				sugestoes.add(c);
			}
		}
		return sugestoes;
	}
	
	public List<Aluno> autoCompleteAluno(String query) {
		List<Aluno> sugestoes = new ArrayList<Aluno>();
		for (Aluno a : getAlunos()) {
			if (a.getNome().toUpperCase().startsWith(query.toUpperCase())) {
				sugestoes.add(a);
			}
		}
		return sugestoes;
	}
	
	public List<Modulo> autoCompleteModulo(String query) {
		List<Modulo> sugestoes = new ArrayList<Modulo>();
		if(getMatricula().getCurso() != null && getMatricula().getCurso().getIdCurso() != null){
			setModulos(moduloDAO.listarModulosCurso(getMatricula().getCurso().getIdCurso()));
		}
		for (Modulo m : getModulos()) {
			if (m.getNome().toUpperCase().startsWith(query.toUpperCase())) {
				sugestoes.add(m);
			}
		}
		return sugestoes;
	}
	
	////////////////////////VALIDATORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public boolean validaCursosAluno() {
		if(getMatricula().getIdMatricula() == null) {
			List<Modulo> modulosAluno = moduloDAO.listarModulosMatriculados(getMatricula().getAluno().getIdUsuario());
			for(Modulo m : modulosAluno) {
				if(getMatricula().getModulo().getIdModulo() == m.getIdModulo()) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aluno já matriculado no modulo!", "Erro"));
					return false;
				}
			}
		}
		return true;
	}
	
	////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public void carregaMatriculasDocumentos() {
		MatriculaDocumento matriculaDocumento = null;
		getMatricula().setMatriculasDocumentos(new ArrayList<MatriculaDocumento>());
		for(Documento documento : documentoDAO.listar(Documento.class)) {
			matriculaDocumento = new MatriculaDocumento();
			matriculaDocumento.setMatricula(getMatricula());
			matriculaDocumento.setDocumento(documento);
			getMatricula().getMatriculasDocumentos().add(matriculaDocumento);
		}
	}
	
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

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}
	
}
