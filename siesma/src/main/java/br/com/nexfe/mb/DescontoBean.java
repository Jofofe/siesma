package br.com.nexfe.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.dao.DescontoDAO;
import br.com.nexfe.entidades.Desconto;

@ManagedBean
@ViewScoped
public class DescontoBean {
	
	private DescontoDAO descontoDAO;
	
	private Desconto desconto;
	
	private Desconto descontoExclusao;
	
	private List<Desconto> descontos;
	
	private List<Desconto> descontosFiltrados;
	
	public void init() {
		descontoDAO = new DescontoDAO();
		setDescontos(descontoDAO.listarDataAtual());
		setDesconto(null);
	}

	public void back() {
		setDesconto(null);
	}

	public void add() {
		setDesconto(new Desconto());
	}
	
	public void edit(Desconto d){
		setDesconto(d);
	}
	
	public void saveAndUpdate() {
		if (getDesconto().getIdDesconto() != null) {
			if (getDesconto().getIdDesconto()> 0) {
				descontoDAO.alterar(getDesconto());			
			}
		} else {
			descontoDAO.salvar(getDesconto());		
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Operação realizada com sucesso!"));
		init();
	}
	
	public boolean canDelete(Desconto d) {
		return d.getDescontosAplicados() == null || d.getDescontosAplicados().isEmpty();
	}
	
	public void selectDelete(Desconto d){
		setDescontoExclusao(d);
	}
	   
	public void delete(){
		descontoDAO.excluir(getDescontoExclusao());
		setDescontoExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Exclusão realizada com sucesso!"));
		init();
	}
	
	////////////////////GETTERS AND SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\

	public Desconto getDesconto() {
		return desconto;
	}

	public void setDesconto(Desconto desconto) {
		this.desconto = desconto;
	}

	public Desconto getDescontoExclusao() {
		return descontoExclusao;
	}

	public void setDescontoExclusao(Desconto descontoExclusao) {
		this.descontoExclusao = descontoExclusao;
	}

	public List<Desconto> getDescontos() {
		return descontos;
	}

	public void setDescontos(List<Desconto> descontos) {
		this.descontos = descontos;
	}

	public List<Desconto> getDescontosFiltrados() {
		return descontosFiltrados;
	}

	public void setDescontosFiltrados(List<Desconto> descontosFiltrados) {
		this.descontosFiltrados = descontosFiltrados;
	}
	
}
