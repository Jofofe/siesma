package br.com.nexfe.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.dao.EmpregadoDAO;
import br.com.nexfe.dao.LancamentoComercialDAO;
import br.com.nexfe.dao.PagamentoProfessorDAO;
import br.com.nexfe.entidades.Empregado;
import br.com.nexfe.entidades.LancamentoComercial;
import br.com.nexfe.entidades.PagamentoProfessor;

@ManagedBean
@ViewScoped
public class PagamentoProfessorBean {
	
	private PagamentoProfessorDAO pagamentoProfessorDAO;
	
	private EmpregadoDAO empregadoDAO;
	
	private LancamentoComercialDAO lancamentoComercialDAO;
	
	private PagamentoProfessor pagamentoProfessor;
	
	private PagamentoProfessor pagamentoProfessorExclusao;
	
	private List<PagamentoProfessor> pagamentosProfessores;
	
	private List<PagamentoProfessor> pagamentosProfessoresFiltrados;
	
	private List<Empregado> empregados;
	
	private List<LancamentoComercial> lancamentosComerciais;
	
	public void init() {
		pagamentoProfessorDAO = new PagamentoProfessorDAO();
		empregadoDAO = new EmpregadoDAO();
		lancamentoComercialDAO = new LancamentoComercialDAO();
		setPagamentosProfessores(pagamentoProfessorDAO.listar(PagamentoProfessor.class));
		setEmpregados(empregadoDAO.listarProfessores());
		setLancamentosComerciais(lancamentoComercialDAO.listarDataAtual());
		setPagamentoProfessor(null);
	}

	public void back() {
		setPagamentoProfessor(null);
	}

	public void add() {
		setPagamentoProfessor(new PagamentoProfessor());
	}
	
	public void edit(PagamentoProfessor p){
		setPagamentoProfessor(p);
	}
	
	public void saveAndUpdate() {
		if (getPagamentoProfessor().getIdPagamentoProfessor() != null) {
			if (getPagamentoProfessor().getIdPagamentoProfessor() > 0) {
				pagamentoProfessorDAO.alterar(getPagamentoProfessor());			
			}
		} else {
			pagamentoProfessorDAO.salvar(getPagamentoProfessor());		
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Operação realizada com sucesso!"));
		init();
	}
	
	//public boolean canDelete(DescontoAplicado d) {
	//	return d.get() == null || d.get.isEmpty();
	//}
	
	public void selectDelete(PagamentoProfessor p){
		setPagamentoProfessorExclusao(p);
	}
	   
	public void delete(){
		pagamentoProfessorDAO.excluir(getPagamentoProfessorExclusao());
		setPagamentoProfessorExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Exclusão realizada com sucesso!"));
		init();
	}
	
	////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\

	public PagamentoProfessor getPagamentoProfessor() {
		return pagamentoProfessor;
	}

	public void setPagamentoProfessor(PagamentoProfessor pagamentoProfessor) {
		this.pagamentoProfessor = pagamentoProfessor;
	}

	public PagamentoProfessor getPagamentoProfessorExclusao() {
		return pagamentoProfessorExclusao;
	}

	public void setPagamentoProfessorExclusao(PagamentoProfessor pagamentoProfessorExclusao) {
		this.pagamentoProfessorExclusao = pagamentoProfessorExclusao;
	}

	public List<PagamentoProfessor> getPagamentosProfessores() {
		return pagamentosProfessores;
	}

	public void setPagamentosProfessores(List<PagamentoProfessor> pagamentosProfessores) {
		this.pagamentosProfessores = pagamentosProfessores;
	}

	public List<PagamentoProfessor> getPagamentosProfessoresFiltrados() {
		return pagamentosProfessoresFiltrados;
	}

	public void setPagamentosProfessoresFiltrados(List<PagamentoProfessor> pagamentosProfessoresFiltrados) {
		this.pagamentosProfessoresFiltrados = pagamentosProfessoresFiltrados;
	}

	public List<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}

	public List<LancamentoComercial> getLancamentosComerciais() {
		return lancamentosComerciais;
	}

	public void setLancamentosComerciais(List<LancamentoComercial> lancamentosComerciais) {
		this.lancamentosComerciais = lancamentosComerciais;
	}
	
}
