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
import br.com.nexfe.dao.EmpregadoDAO;
import br.com.nexfe.dao.FuncaoDAO;
import br.com.nexfe.dao.NivelAcessoDAO;
import br.com.nexfe.entidades.Empregado;
import br.com.nexfe.entidades.Funcao;
import br.com.nexfe.util.UtilCpf;

@ManagedBean
@ViewScoped
public class EmpregadoBean {
	
	private EmpregadoDAO empregadoDAO;
	
	private NivelAcessoDAO nivelAcessoDAO;
	
	private FuncaoDAO funcaoDAO;
	
	private Empregado empregado;
	
	private Empregado empregadoExclusao;
	
	private List<Empregado> empregados;
	
	private List<Empregado> empregadosFiltrados;
	
	private List<Funcao> funcoes;
	
	public void init() {
		empregadoDAO = new EmpregadoDAO();
		nivelAcessoDAO = new NivelAcessoDAO();
		funcaoDAO = new FuncaoDAO();
		setEmpregados(empregadoDAO.listarTodosSemDistincao());
		setFuncoes(funcaoDAO.listar(Funcao.class));
		setEmpregado(null);
	}

	public void back() {
		setEmpregado(null);
	}

	public void add() {
		setEmpregado(new Empregado());
	}
	
	public void edit(Empregado emp){
		setEmpregado(emp);
	}
	
	public void saveAndUpdate() {
		//Criptografar a Senha
		if (getEmpregado().getIdUsuario() != null) {
			if (getEmpregado().getIdUsuario() > 0) {
				empregadoDAO.alterar(getEmpregado());
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Alterado com sucesso!"));
			}
		} else {
			getEmpregado().setDtCadastro(new Date());
			if(getEmpregado().getFuncao().getNomeFuncao().compareTo(ConstantesNivelAcesso.ADMINISTRATIVO.getNome()) == 0) {
				getEmpregado().setNivelAcesso(nivelAcessoDAO.retornaNivelAcesso(ConstantesNivelAcesso.ADMINISTRATIVO.getChave()));
			} else {
				getEmpregado().setNivelAcesso(nivelAcessoDAO.retornaNivelAcesso(ConstantesNivelAcesso.DOCENTE.getChave()));
			}
			empregadoDAO.salvar(getEmpregado());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Incluido com sucesso!"));
		}
		init();
	}
	
	public void selectDelete(Empregado emp){
		setEmpregadoExclusao(emp);
	}
	   
	public void delete(){
		getEmpregadoExclusao().setDtFimVinculo(new Date());
		empregadoDAO.alterar(getEmpregadoExclusao());
		setEmpregadoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Vinculo encerrado com sucesso!"));
		init();
	}
	
	/////////////////////////VALIDATORS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public void validateEmail(FacesContext fc, UIComponent uic, Object obj) throws ValidatorException {
		String email = (String) obj;
		if (email.indexOf('@') == -1) {
			FacesMessage msg = new FacesMessage("Email invalido!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
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

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	
	public Empregado getEmpregadoExclusao() {
		return empregadoExclusao;
	}

	public void setEmpregadoExclusao(Empregado empregadoExclusao) {
		this.empregadoExclusao = empregadoExclusao;
	}

	public List<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}
	
	public List<Empregado> getEmpregadosFiltrados() {
		return empregadosFiltrados;
	}

	public void setEmpregadosFiltrados(List<Empregado> empregadosFiltrados) {
		this.empregadosFiltrados = empregadosFiltrados;
	}

	public List<Funcao> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<Funcao> funcoes) {
		this.funcoes = funcoes;
	}
	
}
