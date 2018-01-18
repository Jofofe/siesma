package br.com.nexfe.mb;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.nexfe.constantes.ConstantesNivelAcesso;
import br.com.nexfe.dao.AlunoDAO;
import br.com.nexfe.dao.GeneroDAO;
import br.com.nexfe.dao.NivelAcessoDAO;
import br.com.nexfe.dao.UfDAO;
import br.com.nexfe.entidades.Aluno;
import br.com.nexfe.entidades.Genero;
import br.com.nexfe.entidades.Uf;
import br.com.nexfe.util.UtilCpf;
import br.com.nexfe.util.UtilCrypt;

@ManagedBean
@ViewScoped
public class AlunoBean {
	
	private AlunoDAO alunoDAO;
	
	private NivelAcessoDAO nivelAcessoDAO;
	
	private GeneroDAO generoDAO;
	
	private UfDAO ufDAO;
		
	private Aluno aluno;
	
	private Aluno alunoExclusao;
	
	private List<Aluno> alunos;
	
	private List<Aluno> alunosFiltrados;
	
	private List<Genero> generos;
	
	private List<Uf> ufs;
	
	public void init() {
		alunoDAO = new AlunoDAO();
		nivelAcessoDAO = new NivelAcessoDAO();
		generoDAO = new GeneroDAO();
		ufDAO = new UfDAO();
		setAlunos(alunoDAO.listarTodosSemDistincao());
		setGeneros(generoDAO.listar(Genero.class));
		setUfs(ufDAO.listar(Uf.class));
		setAluno(null);
	}

	public void back() {
		setAluno(null);
	}

	public void add() {
		setAluno(new Aluno());
	}
	
	public void edit(Aluno a){
		setAluno(a);
	}
	
	public void saveAndUpdate() {
		//Criptografar a Senha
		if (getAluno().getIdUsuario() != null) {
			if (getAluno().getIdUsuario() > 0) {
				alunoDAO.alterar(getAluno());	
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Alterado com sucesso!"));
			}
		} else {
			addPostValues();
			alunoDAO.salvar(getAluno());	
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Incluido com sucesso!"));
		}
		init();
	}
	
	private void addPostValues() {
		String senhaCrypt = getAluno().getSenha();
		getAluno().setDtCadastro(new Date());
		getAluno().setNivelAcesso(nivelAcessoDAO.retornaNivelAcesso(ConstantesNivelAcesso.ALUNO.getChave()));
		getAluno().setSenha(UtilCrypt.criptografia(senhaCrypt));
	}
	
	public void selectDelete(Aluno a){
		setAlunoExclusao(a);
	}
	   
	public void delete(){
		getAlunoExclusao().setDtFimVinculo(new Date());
		alunoDAO.alterar(getAlunoExclusao());
		setAlunoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Vinculo encerrado com sucesso!"));
		init();
	}
	
	public void reativar(){
		getAlunoExclusao().setDtFimVinculo(null);
		alunoDAO.alterar(getAlunoExclusao());
		setAlunoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Vinculo reativado com sucesso!"));
		init();
	}
	
	///////////////////////// VALIDATORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

	public void validateEmail(FacesContext fc, UIComponent uic, Object obj) throws ValidatorException {
		String email = (String) obj;
		if (email.indexOf('@') == -1) {
			FacesMessage msg = new FacesMessage("Email invalido!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		} else {
			for(Aluno a : getAlunos()) {
				if(a.getEmail().equalsIgnoreCase(email)) {
					if(getAluno().getIdUsuario() != null && getAluno().getIdUsuario() == a.getIdUsuario()) {
						System.out.println("Trouxe o mesmo email do aluno sendo alterado");
					} else {
						FacesMessage msg = new FacesMessage("Email já existente!");
						msg.setSeverity(FacesMessage.SEVERITY_ERROR);
						throw new ValidatorException(msg);
					}
				}
			}
		}
	}

	public void validateCpf(FacesContext fc, UIComponent uic, Object obj) throws ValidatorException {
		String cpf = (String) obj;
		if (!UtilCpf.isCpf(cpf)) {
			FacesMessage msg = new FacesMessage("CPF invalido!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

	////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aluno getAlunoExclusao() {
		return alunoExclusao;
	}

	public void setAlunoExclusao(Aluno alunoExclusao) {
		this.alunoExclusao = alunoExclusao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Aluno> getAlunosFiltrados() {
		return alunosFiltrados;
	}

	public void setAlunosFiltrados(List<Aluno> alunosFiltrados) {
		this.alunosFiltrados = alunosFiltrados;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	public List<Uf> getUfs() {
		return ufs;
	}

	public void setUfs(List<Uf> ufs) {
		this.ufs = ufs;
	}
	
}
