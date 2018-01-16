package br.com.nexfe.mb;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.nexfe.constantes.ConstantesStatus;
import br.com.nexfe.dao.FormaPagamentoDAO;
import br.com.nexfe.dao.LancamentoComercialDAO;
import br.com.nexfe.entidades.FormaPagamento;
import br.com.nexfe.entidades.LancamentoComercial;

@ManagedBean
@ViewScoped
public class LancamentoComercialBean {
	
	private LancamentoComercialDAO lancamentoComercialDAO;
	
	private FormaPagamentoDAO formaPagamentoDAO;
	
	private LancamentoComercial lancamentoComercial;
	
	private LancamentoComercial lancamentoComercialExclusao;
	
	private List<FormaPagamento> formasPagamentos;
	
	private List<LancamentoComercial> lancamentosComerciais;
	
	private List<LancamentoComercial> lancamentosComerciaisFiltrados;
	
	public void init() {
		lancamentoComercialDAO = new LancamentoComercialDAO();
		formaPagamentoDAO = new FormaPagamentoDAO();
		setFormasPagamentos(formaPagamentoDAO.listarDataAtual());
		setLancamentosComerciais(lancamentoComercialDAO.listarDataAtual());
		setLancamentoComercial(null);
	}

	public void back() {
		setLancamentoComercial(null);
	}

	public void add() {
		setLancamentoComercial(new LancamentoComercial());
	}
	
	public void edit(LancamentoComercial l){
		setLancamentoComercial(l);
	}
	
	public void saveAndUpdate() {
		alteraStatus();
		if (getLancamentoComercial().getIdLancamentoComercial() != null) {
			if (getLancamentoComercial().getIdLancamentoComercial() > 0) {
				lancamentoComercialDAO.alterar(getLancamentoComercial());	
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Alterado com sucesso!"));
			}
		} else {
			lancamentoComercialDAO.salvar(getLancamentoComercial());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Incluido com sucesso!"));
		}
		init();
	}
	
	private void alteraStatus() {
		if(getLancamentoComercial().getDtPrevista() == null && getLancamentoComercial().getDtRecebimento() == null) {
			getLancamentoComercial().setStatus(ConstantesStatus.SEM_PREVISAO.getNome());
		} else if(getLancamentoComercial().getDtPrevista() != null && getLancamentoComercial().getDtRecebimento() == null) {
			getLancamentoComercial().setStatus(ConstantesStatus.AGUARDANDO_PAGAMENTO.getNome());
		} else if(getLancamentoComercial().getDtRecebimento() != null) {
			if(getLancamentoComercial().getDtPrevista() == null || 
					getLancamentoComercial().getDtRecebimento().compareTo(getLancamentoComercial().getDtPrevista()) <= 0) {
				getLancamentoComercial().setStatus(ConstantesStatus.PAGO_EM_DIA.getNome());
			} else {
				getLancamentoComercial().setStatus(ConstantesStatus.PAGO_COM_ATRASO.getNome());
			}
		}
	}
	
	public void selectDelete(LancamentoComercial l){
		setLancamentoComercialExclusao(l);
	}
	
	//public boolean canDelete(LancamentoComercial l) {
	//	return l.get() == null || l.get().isEmpty();
	//}
	   
	public void delete(){
		lancamentoComercialDAO.excluir(getLancamentoComercialExclusao());
		setLancamentoComercialExclusao(null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Excluido com sucesso!"));
		init();
	}

	public LancamentoComercial getLancamentoComercial() {
		return lancamentoComercial;
	}

	public void setLancamentoComercial(LancamentoComercial lancamentoComercial) {
		this.lancamentoComercial = lancamentoComercial;
	}

	public LancamentoComercial getLancamentoComercialExclusao() {
		return lancamentoComercialExclusao;
	}

	public void setLancamentoComercialExclusao(LancamentoComercial lancamentoComercialExclusao) {
		this.lancamentoComercialExclusao = lancamentoComercialExclusao;
	}

	public List<FormaPagamento> getFormasPagamentos() {
		return formasPagamentos;
	}

	public void setFormasPagamentos(List<FormaPagamento> formasPagamentos) {
		this.formasPagamentos = formasPagamentos;
	}

	public List<LancamentoComercial> getLancamentosComerciais() {
		return lancamentosComerciais;
	}

	public void setLancamentosComerciais(List<LancamentoComercial> lancamentosComerciais) {
		this.lancamentosComerciais = lancamentosComerciais;
	}

	public List<LancamentoComercial> getLancamentosComerciaisFiltrados() {
		return lancamentosComerciaisFiltrados;
	}

	public void setLancamentosComerciaisFiltrados(List<LancamentoComercial> lancamentosComerciaisFiltrados) {
		this.lancamentosComerciaisFiltrados = lancamentosComerciaisFiltrados;
	}

}
