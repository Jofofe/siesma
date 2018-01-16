package br.com.nexfe.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.dao.ClassePagamentoDAO;
import br.com.nexfe.dao.FormaPagamentoDAO;
import br.com.nexfe.entidades.ClassePagamento;
import br.com.nexfe.entidades.FormaPagamento;

@ManagedBean
@ViewScoped
public class FormaPagamentoBean {
	
	private FormaPagamentoDAO formaPagamentoDAO;
	
	private ClassePagamentoDAO classePagamentoDAO;
	
	private FormaPagamento formaPagamento;
	
	private FormaPagamento formaPagamentoExclusao;
	
	private List<ClassePagamento> classesPagamentos;
	
	private List<FormaPagamento> formasPagamentos;
	
	private List<FormaPagamento> formasPagamentosFiltrados;
	
	public void init() {
		formaPagamentoDAO = new FormaPagamentoDAO();
		classePagamentoDAO = new ClassePagamentoDAO();
		setClassesPagamentos(classePagamentoDAO.listar(ClassePagamento.class));
		setFormasPagamentos(formaPagamentoDAO.listarDataAtual());
		setFormaPagamento(null);
	}

	public void back() {
		setFormaPagamento(null);
	}

	public void add() {
		setFormaPagamento(new FormaPagamento());
	}
	
	public void edit(FormaPagamento f){
		setFormaPagamento(f);
	}
	
	public void saveAndUpdate() {
		if (getFormaPagamento().getIdFormaPagamento() != null) {
			if (getFormaPagamento().getIdFormaPagamento() > 0) {
				formaPagamentoDAO.alterar(getFormaPagamento());	
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Alterado com sucesso!"));
			}
		} else {
			formaPagamentoDAO.salvar(getFormaPagamento());	
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Incluido com sucesso!"));
		}
		init();
	}
	
	public void selectDelete(FormaPagamento f){
		setFormaPagamentoExclusao(f);
	}
	
	public boolean canDelete(FormaPagamento f) {
		return f.getLancamentosComerciais() == null || f.getLancamentosComerciais().isEmpty();
	}
	   
	public void delete(){
		formaPagamentoDAO.excluir(getFormaPagamentoExclusao());
		setFormaPagamentoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Excluido com sucesso!"));
		init();
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public FormaPagamento getFormaPagamentoExclusao() {
		return formaPagamentoExclusao;
	}

	public void setFormaPagamentoExclusao(FormaPagamento formaPagamentoExclusao) {
		this.formaPagamentoExclusao = formaPagamentoExclusao;
	}

	public List<ClassePagamento> getClassesPagamentos() {
		return classesPagamentos;
	}

	public void setClassesPagamentos(List<ClassePagamento> classesPagamentos) {
		this.classesPagamentos = classesPagamentos;
	}

	public List<FormaPagamento> getFormasPagamentos() {
		return formasPagamentos;
	}

	public void setFormasPagamentos(List<FormaPagamento> formasPagamentos) {
		this.formasPagamentos = formasPagamentos;
	}

	public List<FormaPagamento> getFormasPagamentosFiltrados() {
		return formasPagamentosFiltrados;
	}

	public void setFormasPagamentosFiltrados(List<FormaPagamento> formasPagamentosFiltrados) {
		this.formasPagamentosFiltrados = formasPagamentosFiltrados;
	}
	
}
